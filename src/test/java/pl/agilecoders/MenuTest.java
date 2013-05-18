package pl.agilecoders;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

public class MenuTest {
    public static final String MENU_GLOWNE = "Menu główne";
    public static final String WYDRUKI = "Wydruki";
    public static final String INFORMACJE = "Informacje";
    public static final String AKTYWNOSCI = "Aktywności";
    public static final String SPRAWY = "Sprawy";
    public static final String ADMINISTRACJA = "Administracja";
    public static final String LISTA_OCZEKUJaCYCH = "Lista oczekujących";
    public static final String MOJE = "Moje";
    public static final String ZMIEN_HASLO = "Zmień hasło";

    private MenuItem root;


    @BeforeMethod
    public void given() {
        MenuItemFactory menuItemFactory = new MenuItemFactoryImpl();

        root = menuItemFactory.create("");
        MenuItem menuGlowne = menuItemFactory.createWithSubs(MENU_GLOWNE, WYDRUKI, INFORMACJE);
        MenuItem menuAktywnosci = menuItemFactory.createWithSubs(AKTYWNOSCI, LISTA_OCZEKUJaCYCH, MOJE);
        MenuItem menuSprawy = menuItemFactory.createWithSubs(SPRAWY, LISTA_OCZEKUJaCYCH, MOJE);
        MenuItem menuAdministracja = menuItemFactory.createWithSubs(ADMINISTRACJA, ZMIEN_HASLO);

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
        assertThat(root.getChildByName(MENU_GLOWNE).getChildren().size()).isEqualTo(4);
        assertThat(root.getChildByName(MENU_GLOWNE).getChildByName(WYDRUKI).getChildren()).isEmpty();
        assertThat(root.getChildByName(MENU_GLOWNE).getChildByName(INFORMACJE).getChildren()).isEmpty();
        assertThat(root.getChildByName(MENU_GLOWNE).getChildByName(AKTYWNOSCI).getChildren().size()).isEqualTo(2);
        assertThat(root.getChildByName(MENU_GLOWNE).getChildByName(SPRAWY).getChildren().size()).isEqualTo(2);
        assertThat(root.getChildByName(ADMINISTRACJA).getChildren().size()).isEqualTo(1);
    }

    @Test
    public void shouldPrintMenu() {
        MenuItemVisitor printer = new MenuItemVisitorImpl();

        //when
        root.accept(printer);
    }
}
