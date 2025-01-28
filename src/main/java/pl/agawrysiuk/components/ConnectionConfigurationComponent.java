package pl.agawrysiuk.components;

import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.theme.lumo.LumoUtility;
import pl.agawrysiuk.service.ConnectionService;

public class ConnectionConfigurationComponent extends VerticalLayout {

    private final String serverName;
    private final ConnectionService connectionService;
    private String serverIp;
    private TextField ipAddressTextField;
    private Button pingButton;

    public ConnectionConfigurationComponent(String serverName, ConnectionService connectionService) {
        this.serverName = serverName;
        this.connectionService = connectionService;
        this.serverIp = this.connectionService.getConnectionIp(serverName);
        setAlignItems(Alignment.CENTER);
        setMaxWidth(250, Unit.PIXELS);
        var text = new H2(this.serverName){{
            addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
        }};

        createPingButton();
        createIpAddressTextField();

        setMargin(true);

        add(text, ipAddressTextField, pingButton);
    }

    private void createPingButton() {
        pingButton = new Button("Ping") {{
            setEnabled(false);
            addClickListener(e -> testConnection());
        }};
    }

    private void testConnection() {
        var ip = ipAddressTextField.getValue();
        var result = connectionService.testConnection(ip);
        if (result) {
            Notification notification = Notification.show("Application submitted!");
            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            serverIp = ip;
            connectionService.setConnectionIp(serverName, serverIp);
        } else {
            Notification notification = Notification.show("Connection failed!");
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        }
    }

    private void createIpAddressTextField() {
        ipAddressTextField = new TextField("IP Address") {{
            setValueChangeMode(ValueChangeMode.EAGER);
            addValueChangeListener(e -> pingButton.setEnabled(!ipAddressTextField.getValue().isEmpty()));
        }};
        if (serverIp != null) {
            ipAddressTextField.setValue(serverIp);
        }
    }
}
