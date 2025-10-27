package com.example.meepmeeptesting;

import static java.lang.Thread.sleep;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;

import org.rowlandhall.meepmeep.MeepMeep;
import org.rowlandhall.meepmeep.roadrunner.DefaultBotBuilder;
import org.rowlandhall.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class strategy1redside {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(400);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive -> drive.trajectorySequenceBuilder(new Pose2d(10.9, -63.8, 1.58))
                        .forward(80)
                        .turn(Math.toRadians(-44))
                        .waitSeconds(3)
                        .back(5)
                        .turn(Math.toRadians(135))
                        .back(50)
                        .forward(40)
                        .turn(Math.toRadians(-135))
//                        .forward(5)
//                        .waitSeconds(3)
                        .turn(Math.toRadians(40))
                        .lineToLinearHeading(new Pose2d(28.6, -9.6, Math.toRadians(180)))
                        .back(7)
                        .waitSeconds(1)
                        .back(7)
                        .waitSeconds(1)
                        .back(7)
                        .waitSeconds(1)
                        .lineToSplineHeading(new Pose2d(22.9, 39.1, Math.toRadians(40)))
                        .waitSeconds(3)
                        .waitSeconds(3)
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