package xyz.przemyk.simpleplanes.setup;

import net.minecraft.item.Items;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import xyz.przemyk.simpleplanes.SimplePlanesMod;
import xyz.przemyk.simpleplanes.upgrades.RocketUpgrade;
import xyz.przemyk.simpleplanes.upgrades.ShooterUpgrade;
import xyz.przemyk.simpleplanes.upgrades.SprayerUpgrade;
import xyz.przemyk.simpleplanes.entities.largeFurnacePlane.LargeFurnacePlaneEntity;
import xyz.przemyk.simpleplanes.upgrades.sprayer.SprayerUpgrade;
import xyz.przemyk.simpleplanes.upgrades.UpgradeType;
import xyz.przemyk.simpleplanes.upgrades.tnt.TNTUpgrade;

@SuppressWarnings("unused")
public class SimplePlanesUpgrades {

    public static final DeferredRegister<UpgradeType> UPGRADE_TYPES = new DeferredRegister<>(SimplePlanesRegistries.UPGRADE_TYPES, SimplePlanesMod.MODID);

    public static void init() {
        UPGRADE_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<UpgradeType> SPRAYER_UPGRADE_TYPE =
            UPGRADE_TYPES.register("sprayer", () ->
                    new UpgradeType(Items.STICK, SprayerUpgrade::new, planeEntity -> true));

    public static final RegistryObject<UpgradeType> ROCKET_UPGRADE_TYPE = UPGRADE_TYPES.register("rocket", () -> new UpgradeType(Items.FIREWORK_STAR, RocketUpgrade::new));
    public static final RegistryObject<UpgradeType> SHOOTER_UPGRADE_TYPE= UPGRADE_TYPES.register("shooter", () -> new UpgradeType(Items.DISPENSER, ShooterUpgrade::new));

    public static final RegistryObject<UpgradeType> TNT_UPGRADE_TYPE =
            UPGRADE_TYPES.register("tnt", () ->
                    new UpgradeType(Items.TNT, TNTUpgrade::new,
                            planeEntity -> planeEntity instanceof LargeFurnacePlaneEntity && planeEntity.getPassengers().size() < 2,
                            true));
}
