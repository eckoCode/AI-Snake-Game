package snake.snakeRandom;

import snake.*;

import java.awt.*;

import java.util.Random;

public class SnakeRandomAgent extends SnakeAgent {
    private Environment environment;
    public SnakeRandomAgent(Cell cell, Color color, Environment environment) {
        super(cell, color, environment);

        this.environment=environment;
    }

    @Override
    protected Action decide(Perception perception) {
        Cell north = perception.getN();
        Cell east = perception.getE();
        Cell south = perception.getS();
        Cell west = perception.getW();

        Random random = environment.getRandom();
        for (int i = 0; i < 15 ;i++) {
            int pos = random.nextInt(4);
            switch (pos) {
                case 0:
                    if (south != null && !south.hasAgent() && !south.hasTail()) {
                        return Action.SOUTH;
                    }
                    break;
                case 1:
                    if (east != null && !east.hasAgent() && !east.hasTail()) {
                        return Action.EAST;
                    }
                    break;
                case 2:
                    if (north != null && !north.hasAgent() && !north.hasTail()) {
                        return Action.NORTH;
                    }
                case 3:
                    if (west != null && !west.hasAgent() && !west.hasTail()) {
                        return Action.WEST;
                    }
            }
        }
        return null;
    }
}