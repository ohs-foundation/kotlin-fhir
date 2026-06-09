plugins {
    id("fhir-model-conventions")
    id("fhir-codegen")
}

val basePackage: String by project

// Run `./gradlew :fhir-model-r4:r4` to generate FHIR models for R4
val codegenTaskR4 = fhirCodegenExtension.newTask("r4") {
    description = "Generate FHIR models for R4"
    this.corePackageFiles.from(
        File(project.rootDir, "third_party/hl7.fhir.r4.core/package").listFiles()
    )
    this.expansionPackageFiles.from(
        File(project.rootDir, "third_party/hl7.fhir.r4.expansions/package").listFiles()
    )
    this.packageName.set("$basePackage.r4")
}

// Run `./gradlew :fhir-model-r4:codegen` to generate and sync FHIR R4 models
val codegen = tasks.register<Sync>("codegen") {
    description = "Generate FHIR R4 models and sync into the main source set."
    from(codegenTaskR4)
    into(project.layout.projectDirectory.dir("src/commonMain/kotlin"))
    finalizedBy(":spotlessApply")
}
