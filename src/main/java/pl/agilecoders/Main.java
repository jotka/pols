package pl.agilecoders;

/**
 * (c) 2013 agilecoders.pl
 * User: jarek
 * Date: 18.05.13
 * Time: 11:46
 */
public class Main {
    public static void main(String[] args) {
        MenuItemFactory menuItemFactory = new MenuItemFactoryImpl();

        MenuItem root = menuItemFactory.create("");
        MenuItem menuGlowne = menuItemFactory.createWithSubs(MenuConsts.MENU_GLOWNE, MenuConsts.WYDRUKI, MenuConsts.INFORMACJE);
        MenuItem menuAktywnosci = menuItemFactory.createWithSubs(MenuConsts.AKTYWNOSCI, MenuConsts.LISTA_OCZEKUJaCYCH, MenuConsts.MOJE);
        MenuItem menuSprawy = menuItemFactory.createWithSubs(MenuConsts.SPRAWY, MenuConsts.LISTA_OCZEKUJaCYCH, MenuConsts.MOJE);
        MenuItem menuAdministracja = menuItemFactory.createWithSubs(MenuConsts.ADMINISTRACJA, MenuConsts.ZMIEN_HASLO);

        root.add(menuGlowne);
        root.add(menuAdministracja);

        menuGlowne.add(menuAktywnosci);
        menuGlowne.add(menuSprawy);


        MenuItemVisitor printer = new MenuItemVisitorImpl();

        root.accept(printer);
    }
}
