package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.IceCreamSalon;
import be.intecbrussel.sellers.IceCreamSeller;
import be.intecbrussel.sellers.NoMoreIceCreamException;
import be.intecbrussel.sellers.PriceList;

public class IceCreamApp {

    public static void main(String[] args) throws NoMoreIceCreamException {

        PriceList priceList = new PriceList();

        priceList.setBallPrice(6);
        priceList.setMagnumStandardPrice(10);
        priceList.setRocketPrice(15);

        IceCreamSeller iceCreamSalon = new IceCreamSalon(priceList);

        Cone.Flavor[] flavors = {Cone.Flavor.STRACIATELLA, Cone.Flavor.BANANA, Cone.Flavor.MOKKA};

        Cone cone = iceCreamSalon.orderCone(flavors);
        IceRocket iceRocket = iceCreamSalon.orderIceRocket();
        Magnum magnum = iceCreamSalon.orderMagnum(Magnum.MagnumType.ALPINENUTS);

        Eatable[] eatableArray = {cone, iceRocket, magnum};

        for (Eatable eatable : eatableArray){
            eatable.eat();
        }
        System.out.println(iceCreamSalon.getProfit());
    }
}
