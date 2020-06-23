package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.*;

public class IceCreamAppV2 {

    public static void main(String[] args) throws NoMoreIceCreamException {

        PriceList priceList = new PriceList();

        priceList.setBallPrice(6);
        priceList.setMagnumStandardPrice(10);
        priceList.setRocketPrice(15);

        Stock stock = new Stock();

        stock.setMagni(5);
        stock.setIceRockets(5);
        stock.setCones(5);
        stock.setBalls(2);

        IceCreamSeller iceCreamCar = new IceCreamCar(priceList, stock);

        Cone.Flavor[] flavors = {Cone.Flavor.STRACIATELLA, Cone.Flavor.BANANA, Cone.Flavor.MOKKA};

        try {
            Cone cone = iceCreamCar.orderCone(flavors);
            IceRocket iceRocket = iceCreamCar.orderIceRocket();
            Magnum magnum = iceCreamCar.orderMagnum(Magnum.MagnumType.ALPINENUTS);

            Eatable[] eatableArray = {cone, iceRocket, magnum};

            for (Eatable eatable : eatableArray){
                eatable.eat();
            }

           } catch (NoMoreIceCreamException nmice) {
            System.out.println("No order is permitted. " + nmice.getMessage());

        } finally {
            System.out.println(iceCreamCar.getProfit());
        }
    }
}
