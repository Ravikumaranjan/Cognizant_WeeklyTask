public interface ExternalApi{String getData();default void send(String m){}}
class MyService{
 private ExternalApi api;
 MyService(ExternalApi api){this.api=api;}
 String fetchData(){return api.getData();}
 void notifyApi(String m){api.send(m);}
}
