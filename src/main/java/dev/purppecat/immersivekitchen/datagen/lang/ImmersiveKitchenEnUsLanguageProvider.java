package dev.purppecat.immersivekitchen.datagen.lang;

import dev.purppecat.immersivekitchen.ImmersiveKitchen;
import dev.purppecat.immersivekitchen.tags.ImmersiveKitchenItemTags;
import dev.purppecat.immersivekitchen.taste.Taste;
import dev.purppecat.immersivekitchen.world.block.ImmersiveKitchenBlocks;
import dev.purppecat.immersivekitchen.world.item.ImmersiveKitchenItems;
import dev.purppecat.immersivekitchen.world.screen.ImmersiveKitchenMenuTypes;
import dev.purppecat.immersivekitchen.world.tabs.ImmersiveKitchenCreativeModeTabs;
import dev.thomasglasser.tommylib.api.data.lang.ExtendedEnUsLanguageProvider;
import net.minecraft.data.PackOutput;

public class ImmersiveKitchenEnUsLanguageProvider extends ExtendedEnUsLanguageProvider {
    public ImmersiveKitchenEnUsLanguageProvider(PackOutput output) {
        super(output, ImmersiveKitchen.MOD_ID);
    }

    @Override
    protected void addTranslations() {
        addTags();
        addTastes();
        addTabs();
        addGUIs();
        addBlocks();
        addItems();
    }

    private void addGUIs() {
        add(ImmersiveKitchenMenuTypes.MORTAR_MENU.getKey(), "Mortar Menu");
    }

    private void addBlocks() {
        add(ImmersiveKitchenBlocks.MORTAR.get(), "Mortar");
    }

    private void addItems() {
        add(ImmersiveKitchenItems.PESTLE.get(), "Pestle");
        add(ImmersiveKitchenItems.LEMON.get(), "Lemon");
        add(ImmersiveKitchenItems.FLOUR.get(), "Flour");
        add(ImmersiveKitchenItems.BUTTER.get(), "Butter");
        add(ImmersiveKitchenItems.BLACK_PEPPER_POWDER.get(), "Black Pepper Powder");
        add(ImmersiveKitchenItems.SALT.get(), "Salt");
    }


    private void addTastes() {
        add(Taste.BITTER.displayName(), "Bitter");
        add(Taste.SWEET.displayName(), "Sweet");
        add(Taste.TANGY.displayName(), "Tangy");
        add(Taste.TART.displayName(), "Tart");
        add(Taste.SALTY.displayName(), "Salty");
        add(Taste.SPICY.displayName(), "Spicy");
        add(Taste.BLAND.displayName(), "Bland");
        add(Taste.DRY.displayName(), "Dry");
        add(Taste.FATTY.displayName(), "Fatty");
        add(Taste.CREAMY.displayName(), "Creamy");
        add(Taste.CRISPY.displayName(), "Crispy");
        add(Taste.FRESH.displayName(), "Fresh");
        add(Taste.CHEWY.displayName(),  "Chewy");
        add(Taste.STARCHY.displayName(), "Starchy");
        add(Taste.INTENSE.displayName(), "Intense");
        add(Taste.JUICY.displayName(), "Juicy");
        add(Taste.NATURAL.displayName(), "Natural");
        add(Taste.POWDERY.displayName(), "Powdery");
        add(Taste.SMOOTH.displayName(), "Smooth");
        add(Taste.SOFT.displayName(), "Soft");
        add(Taste.SOUR.displayName(), "Sour");
        add(Taste.MEATY.displayName(), "Meaty");
        add(Taste.SAVORY.displayName(), "Savory");
        add(Taste.MILD.displayName(), "Mild");
        add(Taste.SPECIAL.displayName(), "Special");
        add(Taste.FLAKY.displayName(), "Flaky");
        add(Taste.OILY.displayName(), "Oily");
        add(Taste.FLORAL.displayName(), "Floral");
        add(Taste.RICH.displayName(), "Rich");
        add(Taste.FISHY.displayName(), "Fishy");
    }

    private void addTabs() {
        add(ImmersiveKitchenCreativeModeTabs.FRUITS_TAB.get(), "Fruits");
        add(ImmersiveKitchenCreativeModeTabs.KITCHEN_TOOLS.get(), "Kitchen Tools");
        add(ImmersiveKitchenCreativeModeTabs.KEY_INGREDIENTS.get(), "Keying Ingredients");
        add(ImmersiveKitchenCreativeModeTabs.SEASONINGS.get(), "Seasonings");
        add(ImmersiveKitchenCreativeModeTabs.VEGETABLES.get(), "Vegetables");
    }

    private void addTags() {
        add(ImmersiveKitchenItemTags.SWEET, "Sweet");
    }
}
