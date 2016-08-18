package net.contargo.types;

/**
 * Get information from a {@link LicensePlate} that may depend on a {@link Country}.
 *
 * @author  Aljona Murygina - murygina@synyx.de
 */
interface LicensePlateHandler {

    /**
     * Validates the given {@link LicensePlate}.
     *
     * @param  licensePlate  to be validated, never {@code null}
     *
     * @return  {@code true} if the given {@link LicensePlate} is valid, else {@code false}
     */
    boolean validate(LicensePlate licensePlate);


    /**
     * Get the formatted value of the given {@link LicensePlate}.
     *
     * @param  licensePlate  to get the formatted value of, never {@code null}
     *
     * @return  the formatted license plate, never {@code null}
     */
    String format(LicensePlate licensePlate);
}