package pl.agawrysiuk.views.configuration;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.lineawesome.LineAwesomeIconUrl;
import pl.agawrysiuk.components.ConnectionConfigurationComponent;
import pl.agawrysiuk.service.ConnectionService;

@PageTitle("Configuration")
@Route("")
@Menu(order = 0, icon = LineAwesomeIconUrl.GLOBE_SOLID)
public class ConfigurationView extends HorizontalLayout {

    public ConfigurationView(@Autowired ConnectionService connectionService) {
        var connectionConfig = new ConnectionConfigurationComponent("Downloader", connectionService);
        var connectionConfig2 = new ConnectionConfigurationComponent("Upscaler",connectionService);
        var connectionConfig3 = new ConnectionConfigurationComponent("Printer", connectionService);

        setAlignItems(FlexComponent.Alignment.CENTER);
        setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        setWrap(true);
        add(connectionConfig, connectionConfig2, connectionConfig3);
    }

}
