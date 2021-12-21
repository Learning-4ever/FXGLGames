package com.almasb.fxglgames.td.ui;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxglgames.td.TowerData;
import com.almasb.fxglgames.td.TowerDefenseApp;
import javafx.scene.layout.HBox;

import java.util.List;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public class TowerSelectionBox extends HBox {

    private Entity cell;

    public TowerSelectionBox(List<TowerData> towerData) {
        setSpacing(5);

        towerData.forEach(data -> {
            var icon = new TowerIcon(data);
            icon.setOnMouseClicked(e -> {
                if (cell != null) {
                    FXGL.<TowerDefenseApp>getAppCast().onTowerSelected(cell, data);
                }
            });

            getChildren().add(icon);
        });
    }

    public void setCell(Entity cell) {
        this.cell = cell;
    }

    public Entity getCell() {
        return cell;
    }
}
