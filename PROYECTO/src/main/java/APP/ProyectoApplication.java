package APP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import java.util.Scanner;
import APP.infrastructure.persistance.repository.UserRepository;
import APP.infrastructure.persistance.repository.DoctorRepository;
import APP.infrastructure.persistance.repository.EnfermeraRepository;
import APP.infrastructure.persistance.repository.RrhhRepository;
import APP.infrastructure.persistance.repository.PatientRepository;
import APP.infrastructure.persistance.repository.PolizaRepository;
import APP.infrastructure.persistance.repository.MedicamentoRepository;
import APP.infrastructure.persistance.repository.OrdenMedicaRepository;
import APP.infrastructure.persistance.repository.InvoiceRepository;
import APP.infrastructure.persistance.entities.UserEntity;
import APP.application.services.MenuService;



@SpringBootApplication
public class ProyectoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProyectoApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(UserRepository usuarioRepo,
                                    DoctorRepository doctorRepo,
                                    EnfermeraRepository enfermeraRepo,
                                    RrhhRepository rrhhRepo,
                                    PatientRepository pacienteRepo,
                                    PolizaRepository polizaRepo,
                                    MedicamentoRepository medicamentoRepo,
                                    OrdenMedicaRepository ordenRepo,
                                    InvoiceRepository invoiceRepo,
                                    MenuService menuService) {
        return args -> {
            Scanner scLogin = new Scanner(System.in);
            UserEntity loggedUser = null;

            try {
                if (!usuarioRepo.existsByUsername("admin")) {
                    UserEntity admin = new UserEntity();
                    admin.setUsername("admin");
                    admin.setPassword("admin");
                    admin.setName("admin");
                    admin.setDocument("0000000000");
                    admin.setEmail("admin@hossys.com");
                    admin.setGender("ADMIN");
                    admin.setPhoneNumber("0000000000");
                    admin.setAddress("Sede principal");
                    admin.setBirthDate(new java.util.Date());
                    admin.setRole(APP.domain.model.enums.Role.ADMINISTRATOR);
                    usuarioRepo.save(admin);
                    System.out.println("Usuario admin creado");
                }
                
                if (!usuarioRepo.existsByUsername("juan uribe")) {
                    UserEntity rh = new UserEntity();
                    rh.setUsername("juan uribe");
                    rh.setPassword("2301");
                    rh.setName("Juan Uribe");
                    rh.setDocument("1138078557");
                    rh.setEmail("juan.uribe@hossys.com");
                    rh.setGender("M");
                    rh.setPhoneNumber("573001234567");
                    rh.setAddress("Bogotá, Colombia");
                    
                    java.util.Calendar cal = java.util.Calendar.getInstance();
                    cal.set(1985, 4, 15);
                    rh.setBirthDate(cal.getTime());
                    
                    rh.setRole(APP.domain.model.enums.Role.RRHH);
                    usuarioRepo.save(rh);
                    System.out.println("Usuario juan uribe (RRHH) creado");
                }
            } catch(Exception e) {
                System.out.println("Warning: no se pudieron crear usuarios iniciales: " + e.getMessage());
            }

            // LOGIN
            while (loggedUser == null) {
                System.out.println("\n=== HOSSYS LOGIN ===");
                System.out.print("Usuario: ");
                String inpUser = scLogin.nextLine().trim();
                System.out.print("Contraseña: ");
                String inpPass = scLogin.nextLine().trim();
                
                var opt = usuarioRepo.findByUsername(inpUser);
                if (opt.isPresent()) {
                    UserEntity found = opt.get();
                    if (inpPass.equals(found.getPassword())) {
                        loggedUser = found;
                        System.out.println("\nBienvenido, " + 
                            (loggedUser.getName() != null ? loggedUser.getName() : loggedUser.getUsername()) + 
                            " (" + loggedUser.getRole() + ")");
                    } else {
                        System.out.println("Contraseña incorrecta, intente de nuevo.");
                    }
                } else {
                    System.out.println("Usuario no encontrado, intente de nuevo.");
                }
            }

            final UserEntity _LOGGED_USER = loggedUser;
            Scanner sc = new Scanner(System.in);
            menuService.mostrarMenuPorRol(_LOGGED_USER, sc);
            
            sc.close();
            scLogin.close();
            System.out.println("\nSaliendo de HOSSYS. Hasta luego!");
        };
    }

}
