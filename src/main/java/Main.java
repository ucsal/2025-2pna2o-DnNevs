import br.com.mariojp.solid.ocp.*;

import java.util.Map;

public class Main {
	public static void main(String[] args) {
		Map<CustomerType, DiscountPolicy> policies = Map.of(
				CustomerType.REGULAR, new RegularPolicy(),
				CustomerType.PREMIUM, new PremiumPolicy(),
				CustomerType.PARTNER, new PartnerPolicy()
		);

		DiscountCalculator calculator = new DiscountCalculator(policies);

		double result = calculator.apply(100.0, CustomerType.PARTNER);
		System.out.println("Desconto aplicado: " + result);
	}
}
