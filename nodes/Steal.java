package nodes;

import methods.Node;

import org.powerbot.script.rt6.ClientContext;

public class Steal extends Node<ClientContext> {

	public Steal(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean condition() {
		System.out.println("Condition Node Steal");
		return ctx.backpack.select().count() < 28 && ctx.objects.select().id(635).poll().inViewport()
				&& ctx.objects.select().id(635).poll().tile()
						.distanceTo(ctx.players.local()) < 5
				&& ctx.players.local().animation() == -1;
	}

	@Override
	public void execute() {
		System.out.println(ctx.backpack.count());
		System.out.println("Execute Node Steal");
		ctx.objects.select().id(635).poll().interact("Steal-from");
	}

}
