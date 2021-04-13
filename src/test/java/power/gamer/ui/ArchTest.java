package power.gamer.ui;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("power.gamer.ui");

        noClasses()
            .that()
            .resideInAnyPackage("power.gamer.ui.service..")
            .or()
            .resideInAnyPackage("power.gamer.ui.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..power.gamer.ui.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
