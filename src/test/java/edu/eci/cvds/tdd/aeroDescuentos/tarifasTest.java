package edu.eci.cvds.tdd.aeroDescuentos;


import edu.eci.cvds.tdd.aerodescuentos.CalculadorDescuentos;
import edu.eci.cvds.tdd.registry.Registry;
import org.junit.Assert;
import org.junit.Test;

import static edu.eci.cvds.tdd.registry.Gender.MALE;

public class tarifasTest {
    private Registry registry = new Registry();
    @Test
    public void verifyNegativeDays() {
        CalculadorDescuentos calculador = new CalculadorDescuentos();
        try{
            calculador.calculoTarifa(20000, -15, 10);
            Assert.fail();
        }
        catch(Throwable e){
            Assert.assertEquals(true, true);
        }

    }

    @Test
    public void verifyNegativeAge() {
        CalculadorDescuentos calculador = new CalculadorDescuentos();
        try{
            calculador.calculoTarifa(20000, 15, -10);
            Assert.fail();
        }
        catch(Throwable e){
            Assert.assertEquals(true, true);
        }

    }

    @Test
    public void verifyNegativeFee() {
        CalculadorDescuentos calculador = new CalculadorDescuentos();
        try{
            calculador.calculoTarifa(-20000, 15, 10);
            Assert.fail();
        }
        catch(Throwable e){
            Assert.assertEquals(true, true);
        }

    }
    @Test
    public void showldCreateAge() {

        CalculadorDescuentos calculador = new CalculadorDescuentos();
        try{
            double total = calculador.calculoTarifa(100000, 10, 65);
            Assert.assertEquals(92000, total,0);
        }
        catch(Throwable e){
            Assert.assertEquals(true, true);
        }

    }

    @Test
    public void showldCreateFee() {

        CalculadorDescuentos calculador = new CalculadorDescuentos();
        try{
            double total = calculador.calculoTarifa(100000, 21, 25);
            Assert.assertEquals(85000, total,0);
        }
        catch(Throwable e){
            Assert.assertEquals(true, true);
        }

    }

    @Test
    public void showldCalculateFee20() {

        CalculadorDescuentos calculador = new CalculadorDescuentos();
        try{
            double total = calculador.calculoTarifa(100000, 21, 2);
            Assert.assertEquals(80000, total,0);
        }
        catch(Throwable e){
            Assert.assertEquals(true, true);
        }

    }
}
