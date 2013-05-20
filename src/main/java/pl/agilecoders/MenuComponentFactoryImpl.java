package pl.agilecoders;

/**
 * (c) 2013 agilecoders.pl
 * User: jarek
 * Date: 18.05.13
 * Time: 07:58
 */
public class MenuComponentFactoryImpl implements MenuComponentFactory {
    @Override
    /**
     * Create menu leaf
     */
    public MenuLeaf createLeaf(String name) {
        return new MenuLeaf(name);
    }

    @Override
    /**
     * Create menu composite
     */
    public MenuComposite createComposite(String name) {
        return new MenuComposite(name);
    }
}
