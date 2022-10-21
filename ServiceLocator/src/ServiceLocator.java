import services.IService;

public class ServiceLocator {
    private static Cache cache;
  
    static
    {
        cache = new Cache();
    }
  
    public static IService getService(String name)
    {
        IService service = cache.getService(name);
  
        if (service != null)
            return service;
        
        InitialContext context = new InitialContext();
        IService anyService = (IService)context.lookup(name);
        cache.addService(anyService);
        return anyService;
    }
}
