import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import methods.Node;
import nodes.MoveToStall;
import nodes.OpenBank;
import nodes.Steal;
import nodes.UseBank;

import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt6.ClientContext;

@Script.Manifest(name = "TeaSteler", description = "Steelt tea and bankt it")
public class Main extends PollingScript<ClientContext> {
	
	@SuppressWarnings("rawtypes")
	private List<Node> nodes = new ArrayList<Node>();

	@Override
	public void start() {
		nodes.addAll(Arrays.asList(new Steal(ctx), new UseBank(ctx), new MoveToStall(ctx), new OpenBank(ctx)));
	}

	@Override
	public void poll() {
		System.out.println("Starting poll");
		Node.iterate(nodes);
	}

}
