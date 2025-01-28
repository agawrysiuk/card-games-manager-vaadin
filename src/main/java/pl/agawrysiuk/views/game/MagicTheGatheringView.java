package pl.agawrysiuk.views.game;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.lineawesome.LineAwesomeIconUrl;
import pl.agawrysiuk.components.GameLogoComponent;

@PageTitle("Magic The Gathering")
@Route("mtg")
@Menu(order = 2, icon = LineAwesomeIconUrl.PLAY_SOLID)
public class MagicTheGatheringView extends HorizontalLayout {

    public MagicTheGatheringView() {
        setSpacing(true);
        add(GameLogoComponent.MTG_GAME_LOGO_COMPONENT);
    }
}
