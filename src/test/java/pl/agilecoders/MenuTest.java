package pl.agilecoders;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

public class MenuTest {

    private MenuItem root;


    @BeforeMethod
    public void given() {
        MenuItemFactory menuItemFactory = new MenuItemFactoryImpl();

        root = menuItemFactory.create("");
        MenuItem menuGlowne = menuItemFactory.createWithSubs(MenuConsts.MENU_GLOWNE, MenuConsts.WYDRUKI, MenuConsts.INFORMACJE);
        MenuItem menuAktywnosci = menuItemFactory.createWithSubs(MenuConsts.AKTYWNOSCI, MenuConsts.LISTA_OCZEKUJaCYCH, MenuConsts.MOJE);
        MenuItem menuSprawy = menuItemFactory.createWithSubs(MenuConsts.SPRAWY, MenuConsts.LISTA_OCZEKUJaCYCH, MenuConsts.MOJE);
        MenuItem menuAdministracja = menuItemFactory.createWithSubs(MenuConsts.ADMINISTRACJA, MenuConsts.ZMIEN_HASLO);

        root.add(menuGlowne);
        root.add(menuAdministracja);

        menuGlowne.add(menuAktywnosci);
        menuGlowne.add(menuSprawy);
    }

    @Test
    /**
     * Menu Główne
        - Wydruki
        - Informacje
        + Aktywności
            - Lista oczekujących
            - Moje
        + Sprawy
            - Lista oczekujących
            - Moje
     + Administracja
        - Zmień hasło
     */
    public void shouldCreateMenu() {
        assertThat(root.getChildren().size()).isEqualTo(2);
        assertThat(root.getChildByName(MenuConsts.MENU_GLOWNE).getChildren().size()).isEqualTo(4);
        assertThat(root.getChildByName(MenuConsts.MENU_GLOWNE).getChildByName(MenuConsts.WYDRUKI).getChildren()).isEmpty();
        assertThat(root.getChildByName(MenuConsts.MENU_GLOWNE).getChildByName(MenuConsts.INFORMACJE).getChildren()).isEmpty();
        assertThat(root.getChildByName(MenuConsts.MENU_GLOWNE).getChildByName(MenuConsts.AKTYWNOSCI).getChildren().size()).isEqualTo(2);
        assertThat(root.getChildByName(MenuConsts.MENU_GLOWNE).getChildByName(MenuConsts.SPRAWY).getChildren().size()).isEqualTo(2);
        assertThat(root.getChildByName(MenuConsts.ADMINISTRACJA).getChildren().size()).isEqualTo(1);
    }

    @Test
    public void shouldPrintMenu() {
        MenuItemVisitor printer = new MenuItemVisitorImpl();

        //when
        root.accept(printer);
    }
}
