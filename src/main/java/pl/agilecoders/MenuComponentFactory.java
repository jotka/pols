package pl.agilecoders;

/**
 * (c) 2013 agilecoders.pl
 * User: jarek
 * Date: 18.05.13
 * Time: 07:58
 */
public interface MenuComponentFactory {
    MenuLeaf createLeaf(String name);
    MenuComposite createComposite(String name);
}
