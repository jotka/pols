package pl.agilecoders;

import java.util.List;

/**
 * (c) 2013 agilecoders.pl
 * User: jarek
 * Date: 18.05.13
 * Time: 07:52
 */
//Component interface

public interface MenuItem {
    public void add(MenuItem g);

    boolean hasChildren();

    String getName();

    public void accept(MenuItemVisitor visitor);

    boolean isLastChild(MenuItem next);

    List<MenuItem> getChildren();

    MenuItem getChildByName(String name);
}
