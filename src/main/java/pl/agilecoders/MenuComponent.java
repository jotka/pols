package pl.agilecoders;

/**
 * (c) 2013 agilecoders.pl
 * User: jarek
 * Date: 18.05.13
 * Time: 07:52
 */
//Component interface

public interface MenuComponent {

    String getName();

    public void accept(MenuVisitor visitor);
}
