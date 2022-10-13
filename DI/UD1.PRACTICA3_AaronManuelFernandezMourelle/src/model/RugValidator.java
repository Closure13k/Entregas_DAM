package model;

import java.util.ArrayList;
import java.util.List;

public class RugValidator {

    private Rug rug;
    private List<String> violations;

    public RugValidator(Rug rug, List<String> violations) {
        this.rug = rug;
        this.violations = violations;
    }

    /**
     * Si alfombra no es válida.
     *
     * @param violations
     */
    public RugValidator(List<String> violations) {
        this.rug = null;
        this.violations = violations;
    }

    /**
     * Si alfombra es válida.
     *
     * @param rug
     */
    public RugValidator(Rug rug) {
        this.rug = rug;
        this.violations = null;
    }

    public RugValidator() {
    }

    public Rug getRug() {
        return rug;
    }

    public void setRug(Rug rug) {
        this.rug = rug;
    }

    public List<String> getViolations() {
        if (violations == null) {
            return new ArrayList<>();
        }
        return violations;
    }

    public void setViolations(List<String> violations) {
        this.violations = violations;
    }

    public boolean isEmptyValue(String value) {
        return value.isBlank();
    }

    public boolean isNumericValid(String heightOrWidth) {
        if (heightOrWidth.isBlank()) {
            return false;
        }
        try {
            Double.parseDouble(heightOrWidth);
        } catch (NumberFormatException nfex) {
            return false;
        }
        return true;
    }
    /**
     * Comprobaciones varias.
     * @param rugName
     * @param rugColor
     * @param rugWidth
     * @param rugHeight
     * @return RugValidator:
     *          - Sin objeto y con una lista de datos si no pasó las validaciones.
     *          - Con objeto y sin lista de datos si las pasó.
     */
    public static RugValidator validateData(String rugName, String rugColor, String rugWidth, String rugHeight) {
        RugValidator rugValidator = new RugValidator();
        List<String> violations = new ArrayList<>();
        if (rugValidator.isEmptyValue(rugName)) {
            violations.add("El nombre no puede estar vacío.");
        }
        if (rugValidator.isEmptyValue(rugColor)) {
            violations.add("El color no puede estar vacío.");
        }
        if (rugValidator.isEmptyValue(rugHeight)) {
            violations.add("La altura no puede estar vacía.");
        } else {
            if (!rugValidator.isNumericValid(rugHeight)) {
                violations.add("Alto tiene que ser un número.");
            }
        }
        if (rugValidator.isEmptyValue(rugWidth)) {
            violations.add("El ancho no puede estar vacío.");
        } else {
            if (!rugValidator.isNumericValid(rugWidth)) {
                violations.add("Ancho tiene que ser un número.");
            }
        }
        if (violations.isEmpty()) {
            rugValidator.setRug(new Rug(rugName, rugColor, rugWidth, rugHeight));
        } else {
            rugValidator.setViolations(violations);
        }
        return rugValidator;
    }
    /**
     * Genera el mensaje de validaciones.
     * @return
     * @throws RugException 
     */
    public String buildViolationData() throws RugException {
        if (this.getViolations().isEmpty()) {
            throw new RugException("Trying to build a String from an empty violation list.");
        }
        StringBuilder sb = new StringBuilder();
        this.getViolations().forEach((violationData) -> {
            sb.append(violationData).append("\n");
        });
        return sb.toString();
    }
}
