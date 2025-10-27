package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;

import org.rowlandhall.meepmeep.MeepMeep;
import org.rowlandhall.meepmeep.core.colorscheme.scheme.ColorSchemeBlueDark;
import org.rowlandhall.meepmeep.roadrunner.DefaultBotBuilder;
import org.rowlandhall.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class strategy2blueside {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(400);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                .setColorScheme(new ColorSchemeBlueDark())
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive -> drive.trajectorySequenceBuilder(new Pose2d(-49.7, 50.7, 2.5))
                        .back(20)
                        .turn(Math.toRadians(-10))
                        .waitSeconds(3)
                        .lineToSplineHeading(new Pose2d(-26.4, 14, Math.toRadians(360)))
                        .back(30)
                        .waitSeconds(1)
                        .lineToSplineHeading(new Pose2d(-36.3, 41.5, Math.toRadians(128)))
                        .waitSeconds(3)
//                        .turn(Math.toRadians(-44))
//                        .waitSeconds(3)
                        .lineToSplineHeading(new Pose2d(-27.8, -9.9, Math.toRadians(360)))
                        .back(7)
                        .waitSeconds(1)
                        .back(7)
                        .waitSeconds(1)
                        .back(7)
                        .waitSeconds(1)
//                        .lineTo(new Vector2d(-36.3, 42.2))
//                        .turn(Math.toRadians(130))
                        .lineToLinearHeading(new Pose2d(-36.3, 42.2, Math.toRadians(130)))
                        .waitSeconds(3)
                        .lineToSplineHeading(new Pose2d(-37, -2.5, Math.toRadians(360)))




                        .build());

        Image img = null;
        try { img = ImageIO.read(new File("C:\\Users\\User\\Downloads\\meepmeepfield 1.png"));
        }
        catch(IOException e) {}

        meepMeep.setBackground(img)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}