package integration;

/**
 * This class is responsible for instantiating all registries.
  */
public class RegistryCreator {
	private ItemRegistry itemRegistry = new ItemRegistry();

        
        public RegistryCreator() {
        }
        /**
         * @return registered item.
         */
	public ItemRegistry getItemRegistry() {
		return itemRegistry;
	}
}
