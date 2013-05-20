package pl.agilecoders;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

public class MenuTest {

    private MenuComposite root;
    private MenuComposite menuGlowne;
    private MenuComponent menuWydruki;
    private MenuComponent menuInformacje;

    private MenuComposite menuAktywnosci;
    private MenuComponent menuListaOczekAktyw;
    private MenuComponent menuMojeAktyw;

    private MenuComposite menuSprawy;
    private MenuComponent menuListaOczekSprawy;
    private MenuComponent menuMojeSprawy;

    private MenuComposite menuAdministracja;
    private MenuComponent menuZmienHaslo;



    @BeforeMethod
    public void given() {
        MenuComponentFactory menuItemFactory = new MenuComponentFactoryImpl();

        root = menuItemFactory.createComposite("");

        menuGlowne = menuItemFactory.createComposite(MenuConsts.MENU_GLOWNE);
        menuWydruki = menuItemFactory.createLeaf(MenuConsts.WYDRUKI);
        menuInformacje = menuItemFactory.createLeaf(MenuConsts.INFORMACJE);

        menuAktywnosci = menuItemFactory.createComposite(MenuConsts.AKTYWNOSCI);
        menuListaOczekAktyw = menuItemFactory.createLeaf(MenuConsts.LISTA_OCZEKUJACYCH);
        menuMojeAktyw = menuItemFactory.createLeaf(MenuConsts.MOJE);

        menuSprawy = menuItemFactory.createComposite(MenuConsts.SPRAWY);
        menuListaOczekSprawy = menuItemFactory.createLeaf(MenuConsts.LISTA_OCZEKUJACYCH);
        menuMojeSprawy = menuItemFactory.createLeaf(MenuConsts.MOJE);

        menuAdministracja = menuItemFactory.createComposite(MenuConsts.ADMINISTRACJA);
        menuZmienHaslo = menuItemFactory.createLeaf(MenuConsts.ZMIEN_HASLO);

        root.add(menuGlowne);
        root.add(menuAdministracja);

        menuGlowne.add(menuWydruki);
        menuGlowne.add(menuInformacje);
        menuGlowne.add(menuAktywnosci);
        menuGlowne.add(menuSprawy);

        menuSprawy.add(menuListaOczekSprawy);
        menuSprawy.add(menuMojeSprawy);

        menuAktywnosci.add(menuListaOczekAktyw);
        menuAktywnosci.add(menuMojeAktyw);

        menuAdministracja.add(menuZmienHaslo);
    }

    @Test
    public void shouldCreateMenu() {
        assertThat(root.getChildren().size()).isEqualTo(2);
        assertThat(menuGlowne.getChildren().size()).isEqualTo(4);
        assertThat(menuAktywnosci.getChildren().size()).isEqualTo(2);
        assertThat(menuSprawy.getChildren().size()).isEqualTo(2);
        assertThat(menuAdministracja.getChildren().size()).isEqualTo(1);
    }

    @Test
    public void shouldPrintMenu() {
        MenuVisitor printer = new MenuVisitorImpl();

        //when
        root.accept(printer);
    }
}
