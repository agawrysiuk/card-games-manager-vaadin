package pl.agawrysiuk.components;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class GameLogoComponent extends VerticalLayout {

    public static GameLogoComponent MTG_GAME_LOGO_COMPONENT = new GameLogoComponent("mtg", "Magic The Gathering");

    public GameLogoComponent(String gameShortName, String gameLongName) {
        addClassName("cursor-pointer");
        setSpacing(false);
        setJustifyContentMode(JustifyContentMode.START);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        Image img = new Image("images/" + gameShortName + ".png", gameLongName) {{
            setWidth("200px");
        }};
        add(img);
        Paragraph paragraph = new Paragraph(gameLongName) {{
            addClassNames(LumoUtility.FontWeight.BOLD);
        }};
        add(paragraph);

        addClickListener(e -> {
            this.getUI().ifPresent(ui ->
                    ui.navigate(gameShortName));
        });
    }
}
