package pl.agawrysiuk.views.home;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import org.vaadin.lineawesome.LineAwesomeIconUrl;
import pl.agawrysiuk.components.GameLogoComponent;

@PageTitle("Home")
@Route("")
@Menu(order = -1, icon = LineAwesomeIconUrl.HOME_SOLID)
public class HomeView extends VerticalLayout {

    public HomeView() {
        setSpacing(true);
        add(createHeader());
        add(GameLogoComponent.MTG_GAME_LOGO_COMPONENT);

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.START);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

    private H2 createHeader() {
        H2 header = new H2("Choose your game");
        header.addClassNames(Margin.Top.XLARGE, Margin.Bottom.MEDIUM);
        return header;
    }
}
