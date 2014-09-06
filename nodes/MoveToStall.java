package nodes;

import methods.Node;

import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.TilePath;

public class MoveToStall extends Node<ClientContext> {

	private final TilePath PATH = new TilePath(ctx, new Tile[] {
			new Tile(3261, 3420, 0), new Tile(3266, 3414, 0),
			new Tile(3268, 3410, 0) });

	public MoveToStall(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean condition() {
		System.out.println("Condition Node MoveToStall");
		return !ctx.objects.select().id(635).poll().inViewport()
				&& ctx.objects.select().id(635).poll().tile()
						.distanceTo(ctx.players.local()) > 5
				&& ctx.backpack.select().count() < 28;
	}

	@Override
	public void execute() {
		System.out.println("Execute Node MoveToStall");
		PATH.traverse();
		ctx.camera.turnTo(ctx.objects.select().id(635).poll());
	}

}
