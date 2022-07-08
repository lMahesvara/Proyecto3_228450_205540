package eventos;

public class PublicEvent {

    private static PublicEvent instance;
    private EventMain eventMain;
    private EventImageView eventImageView;
    private EventChat eventChat;
    private EventLogin eventLogin;
    private EventMenuLeft eventMenuLeft;
    private EventCerrarSesion eventCerrarSesion;

    public static PublicEvent getInstance() {
        if (instance == null) {
            instance = new PublicEvent();
        }
        return instance;
    }

    private PublicEvent() {

    }

    public EventCerrarSesion getEventCerrarSesion() {
        return eventCerrarSesion;
    }

    public void addEventCerrarSesion(EventCerrarSesion eventCerrarSesion) {
        this.eventCerrarSesion = eventCerrarSesion;
    }
    
    

    public EventMenuLeft getEventMenuLeft() {
        return eventMenuLeft;
    }

    public void addEventMenuLeft(EventMenuLeft eventMenuLeft) {
        this.eventMenuLeft = eventMenuLeft;
    }
    
    

    public EventMain getEventMain() {
        return eventMain;
    }

    public void addEventMain(EventMain eventMain) {
        this.eventMain = eventMain;
    }
    
    public void addEventImageView(EventImageView event) {
        this.eventImageView = event;
    }

    public void addEventChat(EventChat event) {
        this.eventChat = event;
    }
    public void addEventLogin(EventLogin event){
        this.eventLogin=event;
    } 
    public EventImageView getEventImageView() {
        return eventImageView;
    }

    public EventLogin getEventLogin() {
        return eventLogin;
    }
    
    public EventChat getEventChat() {
        return eventChat;
    }
}
