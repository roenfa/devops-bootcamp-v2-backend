// package org.devops.bootcamp.actuators;

// import org.devops.bootcamp.repositories.ProductRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.actuate.info.Info;
// import org.springframework.boot.actuate.info.InfoContributor;
// import org.springframework.stereotype.Component;

// import java.util.HashMap;
// import java.util.Map;

// @Component("productInfoContributor")
// public class ProductRepositoryInfoContributor implements InfoContributor {
//     @Autowired
//     ProductRepository productRepository;

//     @Override
//     public void contribute(Info.Builder builder) {
//         Map<String, Integer> details = new HashMap<>();

//         details.put("active", productRepository.countByStatus(1));
//         details.put("inactive", productRepository.countByStatus(0));

//         builder.withDetail("product", details);
//     }
// }
