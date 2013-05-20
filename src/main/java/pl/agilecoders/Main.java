package pl.agilecoders;

/**
 * (c) 2013 agilecoders.pl
 * User: jarek
 * Date: 18.05.13
 * Time: 11:46
 */
public class Main {
    public static void main(String[] args) {
        MenuComponentFactory menuItemFactory = new MenuComponentFactoryImpl();

        MenuComposite root = menuItemFactory.createComposite("");

        MenuComposite menuGlowne = menuItemFactory.createComposite(MenuConsts.MENU_GLOWNE);
        MenuLeaf menuWydruki = menuItemFactory.createLeaf(MenuConsts.WYDRUKI);
        MenuLeaf menuInformacje = menuItemFactory.createLeaf(MenuConsts.INFORMACJE);

        MenuComposite menuAktywnosci = menuItemFactory.createComposite(MenuConsts.AKTYWNOSCI);
        MenuLeaf menuListaOczekAktyw = menuItemFactory.createLeaf(MenuConsts.LISTA_OCZEKUJACYCH);
        MenuLeaf menuMojeAktyw = menuItemFactory.createLeaf(MenuConsts.MOJE);

        MenuComposite menuSprawy = menuItemFactory.createComposite(MenuConsts.SPRAWY);
        MenuLeaf menuListaOczekSprawy = menuItemFactory.createLeaf(MenuConsts.LISTA_OCZEKUJACYCH);
        MenuLeaf menuMojeSprawy = menuItemFactory.createLeaf(MenuConsts.MOJE);

        MenuComposite menuAdministracja = menuItemFactory.createComposite(MenuConsts.ADMINISTRACJA);
        MenuLeaf menuZmienHaslo = menuItemFactory.createLeaf(MenuConsts.ZMIEN_HASLO);

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


        MenuVisitor printer = new MenuVisitorImpl();

        root.accept(printer);
    }
}
