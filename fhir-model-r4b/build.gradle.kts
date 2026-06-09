plugins {
    id("fhir-model-conventions")
    id("fhir-codegen")
}

val basePackage: String by project

// Run `./gradlew :fhir-model-r4b:r4b` to generate FHIR models for R4B
val codegenTaskR4B = fhirCodegenExtension.newTask("r4b") {
    description = "Generate FHIR models for R4B"
    this.corePackageFiles.from(
        File(project.rootDir, "third_party/hl7.fhir.r4b.core/package").listFiles()
    )
    this.expansionPackageFiles.from(
        File(project.rootDir, "third_party/hl7.fhir.r4b.expansions/package").listFiles()
    )
    this.packageName.set("$basePackage.r4b")
}

// Run `./gradlew :fhir-model-r4b:codegen` to generate and sync FHIR R4B models
val codegen = tasks.register<Sync>("codegen") {
    description = "Generate FHIR R4B models and sync into the main source set."
    from(codegenTaskR4B)
    into(project.layout.projectDirectory.dir("src/commonMain/kotlin"))
    finalizedBy(":spotlessApply")
}
