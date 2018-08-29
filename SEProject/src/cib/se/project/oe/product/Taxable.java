package cib.se.project.oe.product;

import cib.se.project.oe.parameter.ParameterHandler;

public interface Taxable {

    final double tax = ParameterHandler.getParameter("TAX_VALUE");

    // Returns the taxes given price!
    public abstract double getTax(double amount);

}
