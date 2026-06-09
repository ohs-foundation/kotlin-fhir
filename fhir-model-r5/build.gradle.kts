plugins {
    id("fhir-model-conventions")
    id("fhir-codegen")
}

val basePackage: String by project

// Run `./gradlew :fhir-model-r5:r5` to generate FHIR models for R5
val codegenTaskR5 = fhirCodegenExtension.newTask("r5") {
    description = "Generate FHIR models for R5"
    this.corePackageFiles.from(
        File(project.rootDir, "third_party/hl7.fhir.r5.core/package").listFiles()
    )
    this.expansionPackageFiles.from(
        File(project.rootDir, "third_party/hl7.fhir.r5.expansions/package").listFiles()
    )
    this.packageName.set("$basePackage.r5")
}

// Run `./gradlew :fhir-model-r5:codegen` to generate and sync FHIR R5 models
val codegen = tasks.register<Sync>("codegen") {
    description = "Generate FHIR R5 models and sync into the main source set."
    from(codegenTaskR5)
    into(project.layout.projectDirectory.dir("src/commonMain/kotlin"))
    finalizedBy(":spotlessApply")
}
