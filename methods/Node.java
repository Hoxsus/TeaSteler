package methods;

import java.util.List;

import org.powerbot.script.ClientAccessor;
import org.powerbot.script.ClientContext;

@SuppressWarnings("rawtypes")
public abstract class Node<C extends ClientContext> extends ClientAccessor<C> {

	public Node(C ctx) {
		super(ctx);
	}

	public abstract boolean condition();

	public abstract void execute();

	public static void iterate(List<Node> list) {
		for (Node node : list) {
			if (node.condition()) {
				node.execute();
			}
		}
	}

}
