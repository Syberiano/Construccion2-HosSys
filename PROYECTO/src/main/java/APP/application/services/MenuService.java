package APP.application.services;

import APP.domain.model.enums.Role;
import APP.infrastructure.persistance.entities.*;
import APP.infrastructure.persistance.repository.*;
import APP.domain.services.RegisterVitalSigns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Service
public class MenuService {
    
    @Autowired
    private UserRepository usuarioRepo;
    
    @Autowired
    private DoctorRepository doctorRepo;
    
    @Autowired
    private EnfermeraRepository enfermeraRepo;
    
    @Autowired
    private RrhhRepository rrhhRepo;
    
    @Autowired
    private PatientRepository pacienteRepo;
    
    @Autowired
    private PolizaRepository polizaRepo;
    
    @Autowired
    private MedicamentoRepository medicamentoRepo;
    
    @Autowired
    private OrdenMedicaRepository ordenRepo;
    
    @Autowired
    private InvoiceRepository invoiceRepo;

    @Autowired
    private RegisterVitalSigns vitalSignsService;

    public void mostrarMenuPorRol(UserEntity loggedUser, Scanner sc) {
        Role rol = loggedUser.getRole();
        
        switch (rol) {
            case ADMINISTRATOR:
                mostrarMenuAdmin(sc, loggedUser);
                break;
            case DOCTOR:
                mostrarMenuDoctor(sc, loggedUser);
                break;
            case NURSE:
                mostrarMenuEnfermera(sc, loggedUser);
                break;
            case PATIENT:
                mostrarMenuPaciente(sc, loggedUser);
                break;
            case RRHH:
            case SUPPORT:
                mostrarMenuRRHH(sc, loggedUser);
                break;
            default:
                System.out.println("Rol no reconocido");
        }
    }

    private void mostrarMenuAdmin(Scanner sc, UserEntity user) {
        boolean running = true;
        while (running) {
            System.out.println("\n=== MENÚ ADMINISTRADOR ===");
            System.out.println("1) Crear usuario (Doctor/Enfermera/Paciente/RRHH)");
            System.out.println("2) Ver todos los usuarios");
            System.out.println("3) Gestionar pólizas");
            System.out.println("4) Gestionar medicamentos");
            System.out.println("5) Ver órdenes médicas");
            System.out.println("6) Ver invoices");
            System.out.println("7) Ver tablas completas");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            
            String opt = sc.nextLine().trim();
            switch (opt) {
                case "1":
                    crearUsuarioDesdeConsola(sc);
                    break;
                case "2":
                    verTodosUsuarios();
                    break;
                case "3":
                    gestionarPolizas(sc);
                    break;
                case "4":
                    gestionarMedicamentos(sc);
                    break;
                case "5":
                    verOrdenesMedicas();
                    break;
                case "6":
                    verInvoices();
                    break;
                case "7":
                    verTablasCompletas();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private void mostrarMenuDoctor(Scanner sc, UserEntity user) {
        boolean running = true;
        while (running) {
            System.out.println("\n=== MENÚ DOCTOR ===");
            System.out.println("1) Crear orden médica");
            System.out.println("2) Ver pacientes");
            System.out.println("3) Prescribir medicamentos");
            System.out.println("4) Ver órdenes médicas creadas");
            System.out.println("5) Consultar medicamentos");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            
            String opt = sc.nextLine().trim();
            switch (opt) {
                case "1":
                    crearOrdenMedica(sc, user);
                    break;
                case "2":
                    verPacientes();
                    break;
                case "3":
                    prescribirMedicamentos(sc, user);
                    break;
                case "4":
                    verOrdenesMedicasPorDoctor(user);
                    break;
                case "5":
                    consultarMedicamentos();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private void mostrarMenuEnfermera(Scanner sc, UserEntity user) {
        boolean running = true;
        while (running) {
            System.out.println("\n=== MENÚ ENFERMERA ===");
            System.out.println("1) Consultar signos vitales");
            System.out.println("2) Consultar medicamentos (solo lectura)");
            System.out.println("3) Ver pacientes");
            System.out.println("4) Ver órdenes médicas");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            
            String opt = sc.nextLine().trim();
            switch (opt) {
                case "1":
                    manejarSignosVitales(sc);
                    break;
                case "2":
                    consultarMedicamentos();
                    break;
                case "3":
                    verPacientes();
                    break;
                case "4":
                    verOrdenesMedicas();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private void mostrarMenuPaciente(Scanner sc, UserEntity user) {
        boolean running = true;
        while (running) {
            System.out.println("\n=== MENÚ PACIENTE ===");
            System.out.println("1) Ver mis datos");
            System.out.println("2) Ver mis pólizas");
            System.out.println("3) Ver mis invoices");
            System.out.println("4) Ver mis órdenes médicas");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            
            String opt = sc.nextLine().trim();
            switch (opt) {
                case "1":
                    verDatosPaciente(user);
                    break;
                case "2":
                    verPolizasPaciente(user);
                    break;
                case "3":
                    verInvoicesPaciente(user);
                    break;
                case "4":
                    verOrdenesPaciente(user);
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private void mostrarMenuRRHH(Scanner sc, UserEntity user) {
        boolean running = true;
        while (running) {
            System.out.println("\n=== MENÚ RRHH ===");
            System.out.println("1) Crear usuario (Doctor/Enfermera/Paciente)");
            System.out.println("2) Administrar personal");
            System.out.println("3) Ver empleados");
            System.out.println("4) Ver pacientes");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            
            String opt = sc.nextLine().trim();
            switch (opt) {
                case "1":
                    crearUsuarioDesdeConsola(sc);
                    break;
                case "2":
                    administrarPersonal(sc);
                    break;
                case "3":
                    verEmpleados();
                    break;
                case "4":
                    verPacientes();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    // ========== MÉTODOS DE CREACIÓN DE USUARIOS ==========

    private void crearUsuarioDesdeConsola(Scanner sc) {
        System.out.println("\n¿Qué tipo de usuario desea crear?");
        System.out.println("1) Doctor");
        System.out.println("2) Enfermera");
        System.out.println("3) Paciente");
        System.out.println("4) RRHH");
        System.out.print("Opción: ");
        
        String tipo = sc.nextLine().trim();
        
        try {
            switch (tipo) {
                case "1":
                    crearDoctor(sc);
                    break;
                case "2":
                    crearEnfermera(sc);
                    break;
                case "3":
                    crearPaciente(sc);
                    break;
                case "4":
                    crearRRHH(sc);
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Intente de nuevo.");
        }
    }

    private void crearDoctor(Scanner sc) {
        System.out.println("\n=== CREAR DOCTOR ===");
        DoctorEntity doctor = new DoctorEntity();
        UserEntity user = new UserEntity();
        
        // Campos OBLIGATORIOS según @Column(nullable = false)
        // 1. Documento (nullable = false, unique = true)
        while (true) {
            try {
                System.out.print("Documento (requerido, único): ");
                String doc = sc.nextLine().trim();
                if (doc.isEmpty()) {
                    throw new IllegalArgumentException("El documento no puede estar vacío");
                }
                if (doctorRepo.existsByDocument(doc) || usuarioRepo.existsByDocument(doc)) {
                    throw new IllegalArgumentException("Ya existe un usuario con este documento");
                }
                doctor.setDocument(doc);
                user.setDocument(doc);
                break;
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage() + " - Intente de nuevo.");
            }
        }
        
        // 2. Nombre (nullable = false)
        while (true) {
            try {
                System.out.print("Nombre completo (requerido): ");
                String name = sc.nextLine().trim();
                if (name.isEmpty()) {
                    throw new IllegalArgumentException("El nombre no puede estar vacío");
                }
                doctor.setName(name);
                user.setName(name);
                break;
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage() + " - Intente de nuevo.");
            }
        }
        
        // Campos OPCIONALES
        System.out.print("Teléfono (opcional): ");
        String phone = sc.nextLine().trim();
        if (!phone.isEmpty()) {
            doctor.setPhoneNumber(phone);
            user.setPhoneNumber(phone);
        }
        
        System.out.print("Dirección (opcional): ");
        String address = sc.nextLine().trim();
        if (!address.isEmpty()) {
            doctor.setAddress(address);
            user.setAddress(address);
        }
        
        System.out.print("Género (M/F/O) (opcional): ");
        String gender = sc.nextLine().trim();
        if (!gender.isEmpty()) {
            doctor.setGender(gender);
            user.setGender(gender);
        }
        
        // Fecha de nacimiento (opcional)
        while (true) {
            try {
                System.out.print("Fecha de nacimiento (YYYY-MM-DD) (opcional): ");
                String fechaStr = sc.nextLine().trim();
                if (!fechaStr.isEmpty()) {
                    LocalDate localDate = LocalDate.parse(fechaStr);
                    Date date = java.sql.Date.valueOf(localDate);
                    doctor.setBirthDate(date);
                    user.setBirthDate(date);
                }
                break;
            } catch (Exception e) {
                System.out.println("❌ Fecha inválida. Formato: YYYY-MM-DD. Intente de nuevo o presione Enter para omitir.");
            }
        }
        
        // Credenciales de usuario (OBLIGATORIAS para login)
        while (true) {
            try {
                System.out.print("Username para login (requerido): ");
                String username = sc.nextLine().trim();
                if (username.isEmpty()) {
                    throw new IllegalArgumentException("El username es obligatorio para el login");
                }
                if (usuarioRepo.existsByUsername(username)) {
                    throw new IllegalArgumentException("Este username ya está en uso");
                }
                user.setUsername(username);
                break;
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage() + " - Intente de nuevo.");
            }
        }
        
        while (true) {
            try {
                System.out.print("Contraseña (requerida): ");
                String password = sc.nextLine().trim();
                if (password.isEmpty()) {
                    throw new IllegalArgumentException("La contraseña es obligatoria");
                }
                user.setPassword(password);
                break;
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage() + " - Intente de nuevo.");
            }
        }
        
        System.out.print("Email (opcional): ");
        String email = sc.nextLine().trim();
        if (!email.isEmpty()) {
            // Validación básica de email
            if (!email.contains("@")) {
                System.out.println("⚠️  Advertencia: El email no parece válido, pero se guardará de todos modos.");
            }
            user.setEmail(email);
        }
        
        // Configurar roles
        doctor.setRole(Role.DOCTOR);
        user.setRole(Role.DOCTOR);
        
        // Generar IDs
        String doctorId = java.util.UUID.randomUUID().toString();
        doctor.setId(doctorId);
        
        // Guardar entidades
        try {
            // Guardar primero el doctor
            doctorRepo.save(doctor);
            // UserEntity tiene @GeneratedValue, NO asignar ID manualmente
            usuarioRepo.save(user);
            System.out.println("\n✅ Doctor creado exitosamente!");
            System.out.println("   - ID Doctor: " + doctor.getId());
            System.out.println("   - ID Usuario: " + user.getId());
            System.out.println("   - Username: " + user.getUsername());
        } catch (Exception e) {
            System.out.println("❌ Error al guardar: " + e.getMessage());
            throw e;
        }
    }

    private void crearEnfermera(Scanner sc) {
        System.out.println("\n=== CREAR ENFERMERA ===");
        EnfermeraEntity enfermera = new EnfermeraEntity();
        UserEntity user = new UserEntity();
        
        // Campos OBLIGATORIOS
        while (true) {
            try {
                System.out.print("Documento (requerido, único): ");
                String doc = sc.nextLine().trim();
                if (doc.isEmpty()) {
                    throw new IllegalArgumentException("El documento no puede estar vacío");
                }
                if (enfermeraRepo.existsByDocument(doc) || usuarioRepo.existsByDocument(doc)) {
                    throw new IllegalArgumentException("Ya existe un usuario con este documento");
                }
                enfermera.setDocument(doc);
                user.setDocument(doc);
                break;
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage() + " - Intente de nuevo.");
            }
        }
        
        while (true) {
            try {
                System.out.print("Nombre completo (requerido): ");
                String name = sc.nextLine().trim();
                if (name.isEmpty()) {
                    throw new IllegalArgumentException("El nombre no puede estar vacío");
                }
                enfermera.setName(name);
                user.setName(name);
                break;
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage() + " - Intente de nuevo.");
            }
        }
        
        // Campos OPCIONALES
        System.out.print("Teléfono (opcional): ");
        String phone = sc.nextLine().trim();
        if (!phone.isEmpty()) {
            enfermera.setPhoneNumber(phone);
            user.setPhoneNumber(phone);
        }
        
        System.out.print("Dirección (opcional): ");
        String address = sc.nextLine().trim();
        if (!address.isEmpty()) {
            enfermera.setAddress(address);
            user.setAddress(address);
        }
        
        System.out.print("Género (M/F/O) (opcional): ");
        String gender = sc.nextLine().trim();
        if (!gender.isEmpty()) {
            enfermera.setGender(gender);
            user.setGender(gender);
        }
        
        while (true) {
            try {
                System.out.print("Fecha de nacimiento (YYYY-MM-DD) (opcional): ");
                String fechaStr = sc.nextLine().trim();
                if (!fechaStr.isEmpty()) {
                    LocalDate localDate = LocalDate.parse(fechaStr);
                    Date date = java.sql.Date.valueOf(localDate);
                    enfermera.setBirthDate(date);
                    user.setBirthDate(date);
                }
                break;
            } catch (Exception e) {
                System.out.println("❌ Fecha inválida. Formato: YYYY-MM-DD. Intente de nuevo o presione Enter para omitir.");
            }
        }
        
        // Campos específicos de Enfermera
        System.out.print("Número de licencia (opcional): ");
        enfermera.setLicenseNumber(sc.nextLine().trim());
        
        System.out.print("Departamento (opcional): ");
        enfermera.setDepartment(sc.nextLine().trim());
        
        // Credenciales de usuario
        while (true) {
            try {
                System.out.print("Username para login (requerido): ");
                String username = sc.nextLine().trim();
                if (username.isEmpty()) {
                    throw new IllegalArgumentException("El username es obligatorio");
                }
                if (usuarioRepo.existsByUsername(username)) {
                    throw new IllegalArgumentException("Este username ya está en uso");
                }
                user.setUsername(username);
                break;
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage() + " - Intente de nuevo.");
            }
        }
        
        while (true) {
            try {
                System.out.print("Contraseña (requerida): ");
                String password = sc.nextLine().trim();
                if (password.isEmpty()) {
                    throw new IllegalArgumentException("La contraseña es obligatoria");
                }
                user.setPassword(password);
                break;
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage() + " - Intente de nuevo.");
            }
        }
        
        System.out.print("Email (opcional): ");
        String email = sc.nextLine().trim();
        if (!email.isEmpty()) {
            if (!email.contains("@")) {
                System.out.println("⚠️  Advertencia: El email no parece válido.");
            }
            user.setEmail(email);
        }
        
        enfermera.setRole(Role.NURSE);
        user.setRole(Role.NURSE);
        
        try {
            enfermeraRepo.save(enfermera);
            // UserEntity tiene @GeneratedValue, NO asignar ID manualmente
            usuarioRepo.save(user);
            System.out.println("\n✅ Enfermera creada exitosamente!");
            System.out.println("   - ID Enfermera: " + enfermera.getId());
            System.out.println("   - ID Usuario: " + user.getId());
            System.out.println("   - Username: " + user.getUsername());
        } catch (Exception e) {
            System.out.println("❌ Error al guardar: " + e.getMessage());
            throw e;
        }
    }

    private void crearPaciente(Scanner sc) {
        System.out.println("\n=== CREAR PACIENTE ===");
        PatientEntity paciente = new PatientEntity();
        UserEntity user = new UserEntity();
        
        // Campos OBLIGATORIOS
        while (true) {
            try {
                System.out.print("Documento (requerido, único): ");
                String doc = sc.nextLine().trim();
                if (doc.isEmpty()) {
                    throw new IllegalArgumentException("El documento no puede estar vacío");
                }
                if (pacienteRepo.existsByDocument(doc) || usuarioRepo.existsByDocument(doc)) {
                    throw new IllegalArgumentException("Ya existe un usuario con este documento");
                }
                paciente.setDocument(doc);
                user.setDocument(doc);
                break;
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage() + " - Intente de nuevo.");
            }
        }
        
        while (true) {
            try {
                System.out.print("Nombre completo (requerido): ");
                String name = sc.nextLine().trim();
                if (name.isEmpty()) {
                    throw new IllegalArgumentException("El nombre no puede estar vacío");
                }
                paciente.setName(name);
                user.setName(name);
                break;
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage() + " - Intente de nuevo.");
            }
        }
        
        // Campos OPCIONALES básicos
        System.out.print("Teléfono (opcional): ");
        String phone = sc.nextLine().trim();
        if (!phone.isEmpty()) {
            paciente.setPhoneNumber(phone);
            user.setPhoneNumber(phone);
        }
        
        System.out.print("Dirección (opcional): ");
        String address = sc.nextLine().trim();
        if (!address.isEmpty()) {
            paciente.setAddress(address);
            user.setAddress(address);
        }
        
        System.out.print("Género (M/F/O) (opcional): ");
        String gender = sc.nextLine().trim();
        if (!gender.isEmpty()) {
            paciente.setGender(gender);
            user.setGender(gender);
        }
        
        while (true) {
            try {
                System.out.print("Fecha de nacimiento (YYYY-MM-DD) (opcional): ");
                String fechaStr = sc.nextLine().trim();
                if (!fechaStr.isEmpty()) {
                    LocalDate localDate = LocalDate.parse(fechaStr);
                    Date date = java.sql.Date.valueOf(localDate);
                    paciente.setBirthDate(date);
                    user.setBirthDate(date);
                }
                break;
            } catch (Exception e) {
                System.out.println("❌ Fecha inválida. Formato: YYYY-MM-DD. Intente de nuevo o presione Enter para omitir.");
            }
        }
        
        // EMERGENCY CONTACT (Recomendado/Opcional según CreatePatient lo requiere)
        System.out.println("\n--- CONTACTO DE EMERGENCIA ---");
        System.out.print("¿Desea agregar contacto de emergencia? (s/n): ");
        String agregarContacto = sc.nextLine().trim().toLowerCase();
        if (agregarContacto.equals("s") || agregarContacto.equals("si")) {
            APP.domain.model.EmergencyContact emergencyContact = new APP.domain.model.EmergencyContact();
            
            while (true) {
                try {
                    System.out.print("Nombre del contacto (requerido): ");
                    String nombreContacto = sc.nextLine().trim();
                    if (nombreContacto.isEmpty()) {
                        throw new IllegalArgumentException("El nombre del contacto es requerido");
                    }
                    emergencyContact.setName(nombreContacto);
                    break;
                } catch (Exception e) {
                    System.out.println("❌ Error: " + e.getMessage() + " - Intente de nuevo.");
                }
            }
            
            while (true) {
                try {
                    System.out.print("Relación (requerido, ej: Padre, Madre, Esposo/a): ");
                    String relacion = sc.nextLine().trim();
                    if (relacion.isEmpty()) {
                        throw new IllegalArgumentException("La relación es requerida");
                    }
                    emergencyContact.setRelationship(relacion);
                    break;
                } catch (Exception e) {
                    System.out.println("❌ Error: " + e.getMessage() + " - Intente de nuevo.");
                }
            }
            
            while (true) {
                try {
                    System.out.print("Teléfono del contacto (requerido): ");
                    String telefonoContacto = sc.nextLine().trim();
                    if (telefonoContacto.isEmpty()) {
                        throw new IllegalArgumentException("El teléfono del contacto es requerido");
                    }
                    emergencyContact.setPhoneNumber(telefonoContacto);
                    break;
                } catch (Exception e) {
                    System.out.println("❌ Error: " + e.getMessage() + " - Intente de nuevo.");
                }
            }
            
            paciente.setEmergencyContact(emergencyContact);
        }
        
        // HEALTH INSURANCE (Recomendado/Opcional según CreatePatient lo requiere)
        System.out.println("\n--- SEGURO DE SALUD ---");
        System.out.print("¿Desea agregar seguro de salud? (s/n): ");
        String agregarSeguro = sc.nextLine().trim().toLowerCase();
        if (agregarSeguro.equals("s") || agregarSeguro.equals("si")) {
            APP.domain.model.HealthInsurance healthInsurance = new APP.domain.model.HealthInsurance();
            
            while (true) {
                try {
                    System.out.print("ID del seguro (requerido): ");
                    String insuranceId = sc.nextLine().trim();
                    if (insuranceId.isEmpty()) {
                        throw new IllegalArgumentException("El ID del seguro es requerido");
                    }
                    healthInsurance.setInsuranceId(insuranceId);
                    break;
                } catch (Exception e) {
                    System.out.println("❌ Error: " + e.getMessage() + " - Intente de nuevo.");
                }
            }
            
            while (true) {
                try {
                    System.out.print("Nombre del proveedor (requerido): ");
                    String providerName = sc.nextLine().trim();
                    if (providerName.isEmpty()) {
                        throw new IllegalArgumentException("El nombre del proveedor es requerido");
                    }
                    healthInsurance.setProviderName(providerName);
                    break;
                } catch (Exception e) {
                    System.out.println("❌ Error: " + e.getMessage() + " - Intente de nuevo.");
                }
            }
            
            while (true) {
                try {
                    System.out.print("Número de póliza (requerido): ");
                    String policyNumber = sc.nextLine().trim();
                    if (policyNumber.isEmpty()) {
                        throw new IllegalArgumentException("El número de póliza es requerido");
                    }
                    healthInsurance.setPolicyNumber(policyNumber);
                    break;
                } catch (Exception e) {
                    System.out.println("❌ Error: " + e.getMessage() + " - Intente de nuevo.");
                }
            }
            
            System.out.print("Detalles de cobertura (opcional): ");
            healthInsurance.setCoverageDetails(sc.nextLine().trim());
            
            paciente.setHealthInsurance(healthInsurance);
        }
        
        // Credenciales de usuario
        while (true) {
            try {
                System.out.print("\nUsername para login (requerido): ");
                String username = sc.nextLine().trim();
                if (username.isEmpty()) {
                    throw new IllegalArgumentException("El username es obligatorio");
                }
                if (usuarioRepo.existsByUsername(username)) {
                    throw new IllegalArgumentException("Este username ya está en uso");
                }
                user.setUsername(username);
                break;
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage() + " - Intente de nuevo.");
            }
        }
        
        while (true) {
            try {
                System.out.print("Contraseña (requerida): ");
                String password = sc.nextLine().trim();
                if (password.isEmpty()) {
                    throw new IllegalArgumentException("La contraseña es obligatoria");
                }
                user.setPassword(password);
                break;
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage() + " - Intente de nuevo.");
            }
        }
        
        System.out.print("Email (opcional): ");
        String email = sc.nextLine().trim();
        if (!email.isEmpty()) {
            if (!email.contains("@")) {
                System.out.println("⚠️  Advertencia: El email no parece válido.");
            }
            user.setEmail(email);
        }
        
        paciente.setRole(Role.PATIENT);
        user.setRole(Role.PATIENT);
        
        try {
            pacienteRepo.save(paciente);
            // UserEntity tiene @GeneratedValue, NO asignar ID manualmente
            usuarioRepo.save(user);
            System.out.println("\n✅ Paciente creado exitosamente!");
            System.out.println("   - ID Paciente: " + paciente.getId());
            System.out.println("   - ID Usuario: " + user.getId());
            System.out.println("   - Username: " + user.getUsername());
        } catch (Exception e) {
            System.out.println("❌ Error al guardar: " + e.getMessage());
            throw e;
        }
        
        // PÓLIZA OBLIGATORIA al crear paciente
        System.out.println("\n=== PÓLIZA DE SEGURO ===");
        System.out.println("Es necesario registrar al menos una póliza para el paciente.");
        
        crearPolizaParaPaciente(sc, paciente);
        
        // Permitir múltiples pólizas
        while (true) {
            System.out.print("\n¿Desea añadir otra póliza? (s/n): ");
            String otra = sc.nextLine().trim().toLowerCase();
            if (otra.equals("s") || otra.equals("si")) {
                crearPolizaParaPaciente(sc, paciente);
            } else {
                break;
            }
        }
    }

    private void crearRRHH(Scanner sc) {
        System.out.println("\n=== CREAR USUARIO RRHH ===");
        RrhhEntity rrhh = new RrhhEntity();
        UserEntity user = new UserEntity();
        
        // Campos OBLIGATORIOS
        while (true) {
            try {
                System.out.print("Documento (requerido, único): ");
                String doc = sc.nextLine().trim();
                if (doc.isEmpty()) {
                    throw new IllegalArgumentException("El documento no puede estar vacío");
                }
                if (rrhhRepo.existsByDocument(doc) || usuarioRepo.existsByDocument(doc)) {
                    throw new IllegalArgumentException("Ya existe un usuario con este documento");
                }
                rrhh.setDocument(doc);
                user.setDocument(doc);
                break;
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage() + " - Intente de nuevo.");
            }
        }
        
        while (true) {
            try {
                System.out.print("Nombre completo (requerido): ");
                String name = sc.nextLine().trim();
                if (name.isEmpty()) {
                    throw new IllegalArgumentException("El nombre no puede estar vacío");
                }
                rrhh.setName(name);
                user.setName(name);
                break;
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage() + " - Intente de nuevo.");
            }
        }
        
        // Campos OPCIONALES
        System.out.print("Teléfono (opcional): ");
        String phone = sc.nextLine().trim();
        if (!phone.isEmpty()) {
            rrhh.setPhoneNumber(phone);
            user.setPhoneNumber(phone);
        }
        
        System.out.print("Dirección (opcional): ");
        String address = sc.nextLine().trim();
        if (!address.isEmpty()) {
            rrhh.setAddress(address);
            user.setAddress(address);
        }
        
        System.out.print("Género (M/F/O) (opcional): ");
        String gender = sc.nextLine().trim();
        if (!gender.isEmpty()) {
            rrhh.setGender(gender);
            user.setGender(gender);
        }
        
        while (true) {
            try {
                System.out.print("Fecha de nacimiento (YYYY-MM-DD) (opcional): ");
                String fechaStr = sc.nextLine().trim();
                if (!fechaStr.isEmpty()) {
                    LocalDate localDate = LocalDate.parse(fechaStr);
                    Date date = java.sql.Date.valueOf(localDate);
                    rrhh.setBirthDate(date);
                    user.setBirthDate(date);
                }
                break;
            } catch (Exception e) {
                System.out.println("❌ Fecha inválida. Formato: YYYY-MM-DD. Intente de nuevo o presione Enter para omitir.");
            }
        }
        
        // Campos específicos de RRHH
        System.out.print("ID de empleado (opcional): ");
        rrhh.setEmployeeId(sc.nextLine().trim());
        
        System.out.print("Departamento (opcional): ");
        rrhh.setDepartment(sc.nextLine().trim());
        
        // Credenciales de usuario
        while (true) {
            try {
                System.out.print("Username para login (requerido): ");
                String username = sc.nextLine().trim();
                if (username.isEmpty()) {
                    throw new IllegalArgumentException("El username es obligatorio");
                }
                if (usuarioRepo.existsByUsername(username)) {
                    throw new IllegalArgumentException("Este username ya está en uso");
                }
                user.setUsername(username);
                break;
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage() + " - Intente de nuevo.");
            }
        }
        
        while (true) {
            try {
                System.out.print("Contraseña (requerida): ");
                String password = sc.nextLine().trim();
                if (password.isEmpty()) {
                    throw new IllegalArgumentException("La contraseña es obligatoria");
                }
                user.setPassword(password);
                break;
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage() + " - Intente de nuevo.");
            }
        }
        
        System.out.print("Email (opcional): ");
        String email = sc.nextLine().trim();
        if (!email.isEmpty()) {
            if (!email.contains("@")) {
                System.out.println("⚠️  Advertencia: El email no parece válido.");
            }
            user.setEmail(email);
        }
        
        rrhh.setRole(Role.RRHH);
        user.setRole(Role.RRHH);
        
        try {
            rrhhRepo.save(rrhh);
            // UserEntity tiene @GeneratedValue, NO asignar ID manualmente
            usuarioRepo.save(user);
            System.out.println("\n✅ Usuario RRHH creado exitosamente!");
            System.out.println("   - ID RRHH: " + rrhh.getId());
            System.out.println("   - ID Usuario: " + user.getId());
            System.out.println("   - Username: " + user.getUsername());
        } catch (Exception e) {
            System.out.println("❌ Error al guardar: " + e.getMessage());
            throw e;
        }
    }

    // ========== MÉTODOS DE GESTIÓN ==========

    private void crearOrdenMedica(Scanner sc, UserEntity doctorUser) {
        System.out.println("\n=== CREAR ORDEN MÉDICA ===");
        OrdenMedicaEntity orden = new OrdenMedicaEntity();

        // Buscar doctor por documento del usuario logueado
        final DoctorEntity doctor = doctorRepo.findAll().stream()
            .filter(d -> d.getDocument().equals(doctorUser.getDocument()))
            .findFirst()
            .orElse(null);

        if (doctor == null) {
            System.out.println("❌ Error: No se encontró un doctor asociado a su usuario.");
            System.out.println("   Por favor, asegúrese de que existe un registro de doctor con su documento.");
            return;
        }

        System.out.println("Doctor: " + doctor.getName() + " (Documento: " + doctor.getDocument() + ")");
        orden.setDoctor(doctor);

        // Buscar paciente
        PatientEntity paciente = null;
        while (paciente == null) {
            System.out.print("Documento del paciente (requerido): ");
            String doc = sc.nextLine().trim();
            if (doc.isEmpty()) {
                System.out.println("❌ El documento no puede estar vacío.");
                continue;
            }
            paciente = pacienteRepo.findAll().stream()
                .filter(p -> p.getDocument().equals(doc))
                .findFirst()
                .orElse(null);
            if (paciente == null) {
                System.out.println("❌ Paciente no encontrado. Intente de nuevo o presione 'x' para cancelar.");
                String cancelar = sc.nextLine().trim();
                if (cancelar.equalsIgnoreCase("x")) {
                    return;
                }
            } else {
                System.out.println("Paciente encontrado: " + paciente.getName());
            }
        }
        final PatientEntity pacienteFinal = paciente;  // Variable final para usar en lambdas
        orden.setPaciente(pacienteFinal);

        // Campos de la orden médica
        System.out.print("Descripción de la orden (opcional): ");
        orden.setDescripcion(sc.nextLine().trim());

        while (true) {
            System.out.print("Diagnóstico (requerido): ");
            String diagnostico = sc.nextLine().trim();
            if (diagnostico.isEmpty()) {
                System.out.println("❌ El diagnóstico es requerido. Intente de nuevo.");
            } else {
                orden.setDiagnostico(diagnostico);
                break;
            }
        }

        System.out.print("Observaciones adicionales (opcional): ");
        orden.setObservaciones(sc.nextLine().trim());

        System.out.print("Estado (ACTIVA/PENDIENTE/CANCELADA) [default: ACTIVA]: ");
        String estado = sc.nextLine().trim();
        if (estado.isEmpty()) {
            estado = "ACTIVA";
        }
        orden.setEstado(estado);
        
        // Medicamentos
        System.out.println("\n--- MEDICAMENTOS PARA PACIENTE: " + pacienteFinal.getName() + " ---");
        System.out.println("Medicamentos disponibles:");
        medicamentoRepo.findAll().forEach(m -> 
            System.out.println("  ID: " + m.getId() + " - " + m.getNombre() + 
                " (Stock: " + (m.getCantidadDisponible() != null ? m.getCantidadDisponible() : 0) + 
                ", Precio: $" + (m.getPrecioUnitario() != null ? m.getPrecioUnitario() : 0) + ")"));
        
        System.out.print("\nIDs de medicamentos separados por comas (ej: 1,2,3) o Enter para omitir: ");
        String idsStr = sc.nextLine().trim();
        List<MedicamentoEntity> medicamentos = new ArrayList<>();
        if (!idsStr.isEmpty()) {
            for (String idStr : idsStr.split(",")) {
                try {
                    Long id = Long.parseLong(idStr.trim());
                    medicamentoRepo.findById(id).ifPresent(med -> {
                        // Asignar doctor prescriptor
                        med.setDoctorPrescriptor(doctor);
                        medicamentoRepo.save(med);
                        medicamentos.add(med);
                        System.out.println("  ✓ Medicamento agregado para paciente " + pacienteFinal.getName() + ": " + med.getNombre());
                    });
                } catch (Exception e) {
                    System.out.println("  ❌ ID inválido: " + idStr);
                }
            }
        }
        orden.setMedicamentosPrescritos(medicamentos);  // Medicamentos relacionados con la orden y el paciente
        
        try {
            ordenRepo.save(orden);
            System.out.println("\n✅ Orden médica creada exitosamente!");
            System.out.println("   - ID Orden: " + orden.getId());
            System.out.println("   - Paciente: " + pacienteFinal.getName() + " (Doc: " + pacienteFinal.getDocument() + ")");
            System.out.println("   - Doctor: " + doctor.getName());
            System.out.println("   - Diagnóstico: " + orden.getDiagnostico());
            System.out.println("   - Medicamentos prescritos: " + medicamentos.size());
            
            // Mostrar medicamentos prescritos
            if (!medicamentos.isEmpty()) {
                System.out.println("\nMedicamentos prescritos para el paciente " + pacienteFinal.getName() + ":");
                medicamentos.forEach(med -> 
                    System.out.println("  - " + med.getNombre() + 
                        (med.getDosis() != null ? " (Dosis: " + med.getDosis() + ")" : "") +
                        (med.getPrecioUnitario() != null ? " - Precio: $" + med.getPrecioUnitario() : "")));
            }
            
            // Generar invoice automáticamente si hay medicamentos
            if (!medicamentos.isEmpty()) {
                generarInvoiceAutomatico(orden, pacienteFinal);
            }
        } catch (Exception e) {
            System.out.println("❌ Error al guardar la orden: " + e.getMessage());
        }
    }

    private void generarInvoiceAutomatico(OrdenMedicaEntity orden, PatientEntity paciente) {
        System.out.println("\n--- GENERANDO INVOICE PARA PACIENTE: " + paciente.getName() + " (Doc: " + paciente.getDocument() + ") ---");

        InvoiceEntity invoice = new InvoiceEntity();
        invoice.setPaciente(paciente);  // SIEMPRE relacionado con el paciente
        invoice.setOrdenMedica(orden);  // Relacionado con la orden médica
        invoice.setFecha(new Date());

        BigDecimal total = BigDecimal.ZERO;
        List<MedicamentoEntity> medicamentos = new ArrayList<>();

        if (orden.getMedicamentosPrescritos() != null) {
            System.out.println("Medicamentos en la orden:");
            for (MedicamentoEntity med : orden.getMedicamentosPrescritos()) {
                if (med.getPrecioUnitario() != null) {
                    total = total.add(BigDecimal.valueOf(med.getPrecioUnitario()));
                    medicamentos.add(med);
                    System.out.println("  - " + med.getNombre() + ": $" + med.getPrecioUnitario());
                }
            }
        }

        invoice.setMedicamentos(medicamentos);  // Medicamentos relacionados con el invoice
        invoice.setTotal(total);
        invoice.setStatus("GENERADA");

        // Buscar póliza activa del paciente
        List<PolizaEntity> polizas = polizaRepo.findByPacienteId(paciente.getId());
        PolizaEntity polizaActiva = polizas.stream()
            .filter(p -> "ACTIVA".equals(p.getEstado()))
            .findFirst()
            .orElse(null);

        if (polizaActiva != null) {
            invoice.setPolicyId(polizaActiva.getNumeroPoliza());
            invoice.setInsuranceCompanyName(polizaActiva.getAsegurado());
            System.out.println("Póliza activa encontrada: " + polizaActiva.getNumeroPoliza());
        } else {
            System.out.println("⚠️  No se encontró póliza activa para el paciente.");
        }

        invoiceRepo.save(invoice);
        System.out.println("\n✅ Invoice generado automáticamente!");
        System.out.println("   - ID Invoice: " + invoice.getId());
        System.out.println("   - Paciente: " + paciente.getName() + " (Doc: " + paciente.getDocument() + ")");
        System.out.println("   - Orden Médica: #" + orden.getId());
        System.out.println("   - Total: $" + total);
        System.out.println("   - Medicamentos: " + medicamentos.size());
    }

    private void crearPolizaParaPaciente(Scanner sc, PatientEntity paciente) {
        System.out.println("\n--- CREAR PÓLIZA PARA PACIENTE: " + paciente.getName() + " ---");
        PolizaEntity poliza = new PolizaEntity();
        poliza.setPaciente(paciente);

        // Número de póliza (OBLIGATORIO según @Column(nullable=false, unique=true))
        while (true) {
            try {
                System.out.print("Número de póliza (requerido, único): ");
                String num = sc.nextLine().trim();
                if (num.isEmpty()) {
                    throw new IllegalArgumentException("El número de póliza no puede estar vacío");
                }
                // Verificar si ya existe
                if (polizaRepo.findByNumeroPoliza(num).isPresent()) {
                    throw new IllegalArgumentException("Ya existe una póliza con este número");
                }
                poliza.setNumeroPoliza(num);
                break;
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage() + " - Intente de nuevo.");
            }
        }

        System.out.print("Asegurado/Proveedor (opcional): ");
        poliza.setAsegurado(sc.nextLine().trim());

        // Fecha inicio (OPCIONAL pero recomendado)
        while (true) {
            try {
                System.out.print("Fecha inicio vigencia (YYYY-MM-DD) (opcional): ");
                String fechaStr = sc.nextLine().trim();
                if (!fechaStr.isEmpty()) {
                    poliza.setVigenciaInicio(LocalDate.parse(fechaStr));
                }
                break;
            } catch (Exception e) {
                System.out.println("❌ Fecha inválida. Formato: YYYY-MM-DD. Intente de nuevo o presione Enter para omitir.");
            }
        }

        // Fecha fin (OPCIONAL pero recomendado)
        while (true) {
            try {
                System.out.print("Fecha fin vigencia (YYYY-MM-DD) (opcional): ");
                String fechaStr = sc.nextLine().trim();
                if (!fechaStr.isEmpty()) {
                    LocalDate fechaFin = LocalDate.parse(fechaStr);
                    // Validar que fecha fin sea posterior a fecha inicio
                    if (poliza.getVigenciaInicio() != null && fechaFin.isBefore(poliza.getVigenciaInicio())) {
                        System.out.println("⚠️  Advertencia: La fecha fin es anterior a la fecha inicio.");
                    }
                    poliza.setVigenciaFin(fechaFin);
                }
                break;
            } catch (Exception e) {
                System.out.println("❌ Fecha inválida. Formato: YYYY-MM-DD. Intente de nuevo o presione Enter para omitir.");
            }
        }

        // Calcular estado automáticamente
        LocalDate hoy = LocalDate.now();
        if (poliza.getVigenciaInicio() == null || poliza.getVigenciaFin() == null) {
            poliza.setEstado("INDETERMINADO");
        } else if (hoy.isBefore(poliza.getVigenciaInicio())) {
            poliza.setEstado("NO_ACTIVA");
        } else if (hoy.isAfter(poliza.getVigenciaFin())) {
            poliza.setEstado("VENCIDA");
        } else {
            poliza.setEstado("ACTIVA");
        }

        try {
            polizaRepo.save(poliza);
            System.out.println("\n✅ Póliza guardada exitosamente!");
            System.out.println("   - Número: " + poliza.getNumeroPoliza());
            System.out.println("   - Estado: " + poliza.getEstado());
            System.out.println("   - Vigencia: " + poliza.getVigenciaInicio() + " a " + poliza.getVigenciaFin());
        } catch (Exception e) {
            System.out.println("❌ Error al guardar: " + e.getMessage());
        }
    }

    private void gestionarPolizas(Scanner sc) {
        System.out.println("\n=== GESTIÓN DE PÓLIZAS ===");
        System.out.println("1) Crear póliza");
        System.out.println("2) Consultar por número");
        System.out.println("3) Ver pólizas de un paciente");
        System.out.print("Opción: ");

        String opt = sc.nextLine().trim();
        switch (opt) {
            case "1":
                System.out.print("Documento del paciente: ");
                String doc = sc.nextLine().trim();
                PatientEntity paciente = pacienteRepo.findAll().stream()
                    .filter(p -> p.getDocument().equals(doc))
                    .findFirst()
                    .orElse(null);
                if (paciente != null) {
                    crearPolizaParaPaciente(sc, paciente);
                } else {
                    System.out.println("Paciente no encontrado");
                }
                break;
            case "2":
                System.out.print("Número de póliza: ");
                String num = sc.nextLine().trim();
                polizaRepo.findByNumeroPoliza(num).ifPresentOrElse(
                    p -> System.out.println("Póliza: " + p.getNumeroPoliza() + " - Estado: " + p.getEstado()),
                    () -> System.out.println("No encontrada")
                );
                break;
            case "3":
                System.out.print("Documento del paciente: ");
                String docPac = sc.nextLine().trim();
                PatientEntity pac = pacienteRepo.findAll().stream()
                    .filter(p -> p.getDocument().equals(docPac))
                    .findFirst()
                    .orElse(null);
                if (pac != null) {
                    List<PolizaEntity> polizas = polizaRepo.findByPacienteId(pac.getId());
                    polizas.forEach(p -> System.out.println("Póliza: " + p.getNumeroPoliza() + " - Estado: " + p.getEstado()));
                } else {
                    System.out.println("Paciente no encontrado");
                }
                break;
        }
    }

    private void gestionarMedicamentos(Scanner sc) {
        System.out.println("\n=== GESTIÓN DE MEDICAMENTOS ===");
        System.out.println("1) Registrar medicamento");
        System.out.println("2) Buscar por nombre");
        System.out.println("3) Actualizar cantidad");
        System.out.print("Opción: ");

        String opt = sc.nextLine().trim();
        switch (opt) {
            case "1":
                System.out.println("\n=== REGISTRAR MEDICAMENTO ===");
                MedicamentoEntity m = new MedicamentoEntity();

                // Nombre (OBLIGATORIO según @Column(nullable=false))
                while (true) {
                    try {
                        System.out.print("Nombre del medicamento (requerido): ");
                        String nombre = sc.nextLine().trim();
                        if (nombre.isEmpty()) {
                            throw new IllegalArgumentException("El nombre es obligatorio");
                        }
                        m.setNombre(nombre);
                        break;
                    } catch (Exception e) {
                        System.out.println("❌ Error: " + e.getMessage() + " - Intente de nuevo.");
                    }
                }

                // Cantidad disponible (OPCIONAL)
                while (true) {
                    try {
                        System.out.print("Cantidad disponible/Stock (opcional, número entero): ");
                        String cantidadStr = sc.nextLine().trim();
                        if (cantidadStr.isEmpty()) {
                            m.setCantidadDisponible(0);
                            break;
                        }
                        int cantidad = Integer.parseInt(cantidadStr);
                        if (cantidad < 0) {
                            throw new IllegalArgumentException("La cantidad no puede ser negativa");
                        }
                        m.setCantidadDisponible(cantidad);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Error: Debe ingresar un número entero válido.");
                    } catch (Exception e) {
                        System.out.println("❌ Error: " + e.getMessage());
                    }
                }

                // Dosis (OPCIONAL)
                System.out.print("Dosis recomendada (opcional, ej: 500mg cada 8 horas): ");
                m.setDosis(sc.nextLine().trim());

                // Precio unitario (OPCIONAL)
                while (true) {
                    try {
                        System.out.print("Precio unitario (opcional, número decimal): ");
                        String precioStr = sc.nextLine().trim();
                        if (precioStr.isEmpty()) {
                            m.setPrecioUnitario(0.0);
                            break;
                        }
                        double precio = Double.parseDouble(precioStr);
                        if (precio < 0) {
                            throw new IllegalArgumentException("El precio no puede ser negativo");
                        }
                        m.setPrecioUnitario(precio);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Error: Debe ingresar un número válido (ej: 10.50).");
                    } catch (Exception e) {
                        System.out.println("❌ Error: " + e.getMessage());
                    }
                }

                // Fecha de vencimiento (OPCIONAL)
                while (true) {
                    try {
                        System.out.print("Fecha de vencimiento (YYYY-MM-DD) (opcional): ");
                        String fechaStr = sc.nextLine().trim();
                        if (fechaStr.isEmpty()) {
                            break;
                        }
                        m.setFechaVencimiento(LocalDate.parse(fechaStr));
                        break;
                    } catch (Exception e) {
                        System.out.println("❌ Fecha inválida. Formato: YYYY-MM-DD. Intente de nuevo o presione Enter para omitir.");
                    }
                }

                try {
                    medicamentoRepo.save(m);
                    System.out.println("\n✅ Medicamento registrado exitosamente!");
                    System.out.println("   - ID: " + m.getId());
                    System.out.println("   - Nombre: " + m.getNombre());
                    System.out.println("   - Stock: " + m.getCantidadDisponible());
                    System.out.println("   - Precio: $" + m.getPrecioUnitario());
                } catch (Exception e) {
                    System.out.println("❌ Error al guardar: " + e.getMessage());
                }
                break;
            case "2":
                System.out.print("Nombre (parte): ");
                medicamentoRepo.findByNombreContainingIgnoreCase(sc.nextLine().trim())
                    .forEach(mm -> System.out.println(mm.getId() + " - " + mm.getNombre() +
                        " - qty: " + mm.getCantidadDisponible() +
                        " - precio: $" + mm.getPrecioUnitario()));
                break;
            case "3":
                System.out.print("Id medicamento: ");
                try {
                    Long idm = Long.parseLong(sc.nextLine().trim());
                    System.out.print("Delta (ej +10 o -2): ");
                    int delta = Integer.parseInt(sc.nextLine().trim());
                    medicamentoRepo.findById(idm).ifPresentOrElse(
                        med -> {
                            int nueva = (med.getCantidadDisponible() == null ? 0 : med.getCantidadDisponible()) + delta;
                            med.setCantidadDisponible(Math.max(0, nueva));
                            medicamentoRepo.save(med);
                            System.out.println("Actualizado qty: " + med.getCantidadDisponible());
                        },
                        () -> System.out.println("Medicamento no encontrado")
                    );
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
        }
    }

    private void prescribirMedicamentos(Scanner sc, UserEntity doctorUser) {
        System.out.println("\n=== PRESCRIBIR MEDICAMENTOS ===");

        // Buscar doctor
        final DoctorEntity doctor = doctorRepo.findAll().stream()
            .filter(d -> d.getDocument().equals(doctorUser.getDocument()))
            .findFirst()
            .orElse(null);

        if (doctor == null) {
            System.out.println("❌ Error: No se encontró un doctor asociado a su usuario.");
            return;
        }

        System.out.print("ID de orden médica: ");
        try {
            Long ordenId = Long.parseLong(sc.nextLine().trim());
            ordenRepo.findById(ordenId).ifPresentOrElse(
                orden -> {
                    // Verificar que la orden pertenece al doctor
                    if (!orden.getDoctor().getId().equals(doctor.getId())) {
                        System.out.println("❌ Error: Esta orden médica no pertenece a usted.");
                        return;
                    }

                    // Mostrar información del paciente de la orden
                    PatientEntity pacienteOrden = orden.getPaciente();
                    System.out.println("\n--- ORDEN MÉDICA #" + orden.getId() + " ---");
                    System.out.println("Paciente: " + pacienteOrden.getName() + " (Doc: " + pacienteOrden.getDocument() + ")");
                    System.out.println("Diagnóstico: " + (orden.getDiagnostico() != null ? orden.getDiagnostico() : "N/A"));

                    System.out.println("\nMedicamentos disponibles:");
                    medicamentoRepo.findAll().forEach(m ->
                        System.out.println("  ID: " + m.getId() + " - " + m.getNombre() +
                            " (Stock: " + (m.getCantidadDisponible() != null ? m.getCantidadDisponible() : 0) +
                            ", Precio: $" + (m.getPrecioUnitario() != null ? m.getPrecioUnitario() : 0) + ")"));

                    System.out.print("\nIDs de medicamentos separados por comas (ej: 1,2,3): ");
                    String idsStr = sc.nextLine().trim();
                    List<MedicamentoEntity> medicamentos = new ArrayList<>();

                    if (!idsStr.isEmpty()) {
                        for (String idStr : idsStr.split(",")) {
                            try {
                                Long id = Long.parseLong(idStr.trim());
                                medicamentoRepo.findById(id).ifPresent(med -> {
                                    // Verificar stock
                                    int stockActual = med.getCantidadDisponible() != null ? med.getCantidadDisponible() : 0;
                                    if (stockActual <= 0) {
                                        System.out.println("  ⚠️  Advertencia: " + med.getNombre() + " está sin stock.");
                                    }

                                    // Asignar doctor prescriptor
                                    med.setDoctorPrescriptor(doctor);
                                    medicamentoRepo.save(med);
                                    medicamentos.add(med);
                                    System.out.println("  ✓ Medicamento agregado para paciente " + pacienteOrden.getName() + ": " + med.getNombre());

                                    // Disminuir stock (opcional, puede comentarse si no se desea)
                                    if (stockActual > 0) {
                                        med.setCantidadDisponible(stockActual - 1);
                                        medicamentoRepo.save(med);
                                        System.out.println("    → Stock actualizado: " + med.getCantidadDisponible());
                                    }
                                });
                            } catch (Exception e) {
                                System.out.println("  ❌ ID inválido: " + idStr);
                            }
                        }
                    }

                    if (orden.getMedicamentosPrescritos() == null) {
                        orden.setMedicamentosPrescritos(new ArrayList<>());
                    }
                    orden.getMedicamentosPrescritos().addAll(medicamentos);
                    ordenRepo.save(orden);

                    System.out.println("\n✅ Medicamentos prescritos agregados a la orden #" + orden.getId());
                    System.out.println("   - Paciente: " + pacienteOrden.getName() + " (Doc: " + pacienteOrden.getDocument() + ")");
                    System.out.println("   - Medicamentos agregados: " + medicamentos.size());

                    // Generar invoice automáticamente (SIEMPRE relacionado con el paciente de la orden)
                    if (!medicamentos.isEmpty()) {
                        generarInvoiceAutomatico(orden, pacienteOrden);
                    }
                },
                () -> System.out.println("❌ Orden médica no encontrada")
            );
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    // ========== MÉTODOS DE CONSULTA ==========

    private void verTodosUsuarios() {
        System.out.println("\n=== USUARIOS ===");
        usuarioRepo.findAll().forEach(u ->
            System.out.println("ID: " + u.getId() + " - " + u.getName() + " (" + u.getRole() + ")"));

        System.out.println("\n=== DOCTORES ===");
        doctorRepo.findAll().forEach(d ->
            System.out.println("ID: " + d.getId() + " - " + d.getName() + " - Doc: " + d.getDocument()));

        System.out.println("\n=== ENFERMERAS ===");
        enfermeraRepo.findAll().forEach(e ->
            System.out.println("ID: " + e.getId() + " - " + e.getName() + " - Doc: " + e.getDocument()));

        System.out.println("\n=== RRHH ===");
        rrhhRepo.findAll().forEach(r ->
            System.out.println("ID: " + r.getId() + " - " + r.getName() + " - Doc: " + r.getDocument()));

        System.out.println("\n=== PACIENTES ===");
        pacienteRepo.findAll().forEach(p ->
            System.out.println("ID: " + p.getId() + " - " + p.getName() + " - Doc: " + p.getDocument()));
    }

    private void verPacientes() {
        System.out.println("\n=== PACIENTES ===");
        pacienteRepo.findAll().forEach(p ->
            System.out.println("ID: " + p.getId() + " - " + p.getName() + " - Doc: " + p.getDocument() +
                " - Tel: " + p.getPhoneNumber()));
    }

    private void verOrdenesMedicas() {
        System.out.println("\n=== ÓRDENES MÉDICAS ===");
        ordenRepo.findAll().forEach(om -> 
            System.out.println("ID: " + om.getId() + " - Paciente: " + om.getPaciente().getName() +
                " - Doctor: " + om.getDoctor().getName() + " - Estado: " + om.getEstado()));
    }

    private void verOrdenesMedicasPorDoctor(UserEntity doctorUser) {
        System.out.println("\n=== MIS ÓRDENAS MÉDICAS ===");
        DoctorEntity doctor = doctorRepo.findAll().stream()
            .filter(d -> d.getDocument().equals(doctorUser.getDocument()))
            .findFirst()
            .orElse(null);
        
        if (doctor != null) {
            List<OrdenMedicaEntity> ordenes = ordenRepo.findByDoctorId(doctor.getId());
            ordenes.forEach(om -> 
                System.out.println("ID: " + om.getId() + " - Paciente: " + om.getPaciente().getName() +
                    " - Diagnóstico: " + om.getDiagnostico() + " - Estado: " + om.getEstado()));
        }
    }

    private void verInvoices() {
        System.out.println("\n=== INVOICES ===");
        invoiceRepo.findAll().forEach(inv -> 
            System.out.println("ID: " + inv.getId() + " - Paciente: " + (inv.getPaciente() != null ? inv.getPaciente().getName() : "<sin paciente>") +
                " - Total: $" + inv.getTotal() + " - Estado: " + inv.getStatus()));
    }

    private void verDatosPaciente(UserEntity user) {
        PatientEntity paciente = pacienteRepo.findAll().stream()
            .filter(p -> p.getDocument().equals(user.getDocument()))
            .findFirst()
            .orElse(null);

        if (paciente != null) {
            System.out.println("\n=== MIS DATOS ===");
            System.out.println("Nombre: " + paciente.getName());
            System.out.println("Documento: " + paciente.getDocument());
            System.out.println("Teléfono: " + paciente.getPhoneNumber());
            System.out.println("Dirección: " + paciente.getAddress());
            System.out.println("Género: " + paciente.getGender());
        } else {
            System.out.println("No se encontraron datos de paciente");
        }
    }

    private void verPolizasPaciente(UserEntity user) {
        PatientEntity paciente = pacienteRepo.findAll().stream()
            .filter(p -> p.getDocument().equals(user.getDocument()))
            .findFirst()
            .orElse(null);

        if (paciente != null) {
            List<PolizaEntity> polizas = polizaRepo.findByPacienteId(paciente.getId());
            System.out.println("\n=== MIS PÓLIZAS ===");
            if (polizas.isEmpty()) {
                System.out.println("No tiene pólizas registradas");
            } else {
                polizas.forEach(p ->
                    System.out.println("Póliza: " + p.getNumeroPoliza() + " - Estado: " + p.getEstado() +
                        " - Vigencia: " + p.getVigenciaInicio() + " a " + p.getVigenciaFin()));
            }
        }
    }

    private void verInvoicesPaciente(UserEntity user) {
        PatientEntity paciente = pacienteRepo.findAll().stream()
            .filter(p -> p.getDocument().equals(user.getDocument()))
            .findFirst()
            .orElse(null);
        
        if (paciente != null) {
            List<InvoiceEntity> invoices = invoiceRepo.findByPacienteId(paciente.getId());
            System.out.println("\n=== MIS INVOICES ===");
            if (invoices.isEmpty()) {
                System.out.println("No tiene invoices");
            } else {
                invoices.forEach(inv -> 
                    System.out.println("ID: " + inv.getId() + " - Fecha: " + inv.getFecha() + 
                        " - Total: $" + inv.getTotal() + " - Estado: " + inv.getStatus()));
            }
        }
    }

    private void verOrdenesPaciente(UserEntity user) {
        PatientEntity paciente = pacienteRepo.findAll().stream()
            .filter(p -> p.getDocument().equals(user.getDocument()))
            .findFirst()
            .orElse(null);
        
        if (paciente != null) {
            List<OrdenMedicaEntity> ordenes = ordenRepo.findByPacienteId(paciente.getId());
            System.out.println("\n=== MIS ÓRDENAS MÉDICAS ===");
            if (ordenes.isEmpty()) {
                System.out.println("No tiene órdenes médicas");
            } else {
                ordenes.forEach(om -> 
                    System.out.println("ID: " + om.getId() + " - Doctor: " + om.getDoctor().getName() +
                        " - Diagnóstico: " + om.getDiagnostico() + " - Estado: " + om.getEstado()));
            }
        }
    }

    private void consultarMedicamentos() {
        System.out.println("\n=== MEDICAMENTOS DISPONIBLES ===");
        medicamentoRepo.findAll().forEach(m -> 
            System.out.println("ID: " + m.getId() + " - " + m.getNombre() + 
                " - Stock: " + m.getCantidadDisponible() + 
                " - Precio: $" + m.getPrecioUnitario() + 
                (m.getDosis() != null ? " - Dosis: " + m.getDosis() : "")));
    }

    private void verTablasCompletas() {
        verTodosUsuarios();
        System.out.println("\n=== MEDICAMENTOS ===");
        medicamentoRepo.findAll().forEach(m -> 
            System.out.println("ID: " + m.getId() + " - " + m.getNombre()));
        verOrdenesMedicas();
        verInvoices();
    }

    private void administrarPersonal(Scanner sc) {
        System.out.println("\n=== ADMINISTRAR PERSONAL ===");
        System.out.println("1) Ver doctores");
        System.out.println("2) Ver enfermeras");
        System.out.println("3) Ver RRHH");
        System.out.print("Opción: ");
        
        String opt = sc.nextLine().trim();
        switch (opt) {
            case "1":
                doctorRepo.findAll().forEach(d -> 
                    System.out.println("ID: " + d.getId() + " - " + d.getName() + " - Doc: " + d.getDocument()));
                break;
            case "2":
                enfermeraRepo.findAll().forEach(e -> 
                    System.out.println("ID: " + e.getId() + " - " + e.getName() + " - Doc: " + e.getDocument() + 
                        " - Licencia: " + e.getLicenseNumber()));
                break;
            case "3":
                rrhhRepo.findAll().forEach(r -> 
                    System.out.println("ID: " + r.getId() + " - " + r.getName() + " - Doc: " + r.getDocument() + 
                        " - Empleado ID: " + r.getEmployeeId()));
                break;
        }
    }

    private void verEmpleados() {
        System.out.println("\n=== EMPLEADOS ===");
        System.out.println("=== DOCTORES ===");
        doctorRepo.findAll().forEach(d -> 
            System.out.println("ID: " + d.getId() + " - " + d.getName() + " - Doc: " + d.getDocument()));
        System.out.println("\n=== ENFERMERAS ===");
        enfermeraRepo.findAll().forEach(e -> 
            System.out.println("ID: " + e.getId() + " - " + e.getName() + " - Doc: " + e.getDocument()));
        System.out.println("\n=== RRHH ===");
        rrhhRepo.findAll().forEach(r -> 
            System.out.println("ID: " + r.getId() + " - " + r.getName() + " - Doc: " + r.getDocument()));
    }

    private void manejarSignosVitales(Scanner sc) {
        System.out.println("\n--- SIGNOS VITALES ---");
        System.out.println("1) Registrar signos vitales para un paciente");
        System.out.println("2) Consultar signos vitales por documento de paciente");
        System.out.println("0) Volver");
        System.out.print("Opción: ");
        String opt = sc.nextLine().trim();
        switch (opt) {
            case "1":
                registrarSignosParaPaciente(sc);
                break;
            case "2":
                consultarSignosPorDocumento(sc);
                break;
            case "0":
                return;
            default:
                System.out.println("Opción inválida");
        }
    }

    private void registrarSignosParaPaciente(Scanner sc) {
        System.out.println("\n--- REGISTRAR SIGNOS VITALES ---");
        System.out.print("Documento del paciente: ");
        String doc = sc.nextLine().trim();
        if (doc.isEmpty()) {
            System.out.println("Documento inválido");
            return;
        }
        PatientEntity paciente = pacienteRepo.findAll().stream()
            .filter(p -> p.getDocument().equals(doc))
            .findFirst().orElse(null);
        if (paciente == null) {
            System.out.println("Paciente no encontrado");
            return;
        }

        try {
            System.out.print("Presión arterial (ej: 120/80): ");
            String presion = sc.nextLine().trim();
            System.out.print("Frecuencia cardiaca (lpm): ");
            int fc = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Temperatura (°C): ");
            double temp = Double.parseDouble(sc.nextLine().trim());
            System.out.print("Peso (kg): ");
            double peso = Double.parseDouble(sc.nextLine().trim());

            vitalSignsService.register(paciente.getId(), presion, fc, temp, peso);
            System.out.println("Signos vitales registrados para paciente: " + paciente.getName());
        } catch (NumberFormatException nfe) {
            System.out.println("Entrada numérica inválida. Operación cancelada.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void consultarSignosPorDocumento(Scanner sc) {
        System.out.println("\n--- CONSULTAR SIGNOS VITALES ---");
        System.out.print("Documento del paciente: ");
        String doc = sc.nextLine().trim();
        if (doc.isEmpty()) {
            System.out.println("Documento inválido");
            return;
        }
        PatientEntity paciente = pacienteRepo.findAll().stream()
            .filter(p -> p.getDocument().equals(doc))
            .findFirst().orElse(null);
        if (paciente == null) {
            System.out.println("Paciente no encontrado");
            return;
        }

        try {
            APP.infrastructure.persistance.entities.VitalSignEntity ultimo = vitalSignsService.getLatest(paciente.getId());
            System.out.println("Signos vitales (último registro) para " + paciente.getName() + " (Doc: " + paciente.getDocument() + "): ");
            System.out.println("  - Presión Arterial: " + ultimo.getBloodPressure());
            System.out.println("  - Frecuencia Cardiaca: " + (ultimo.getHeartRate() != null ? ultimo.getHeartRate() + " lpm" : "N/A"));
            System.out.println("  - Temperatura: " + (ultimo.getTemperature() != null ? ultimo.getTemperature() + " °C" : "N/A"));
            System.out.println("  - Peso: " + (ultimo.getWeight() != null ? ultimo.getWeight() + " kg" : "N/A"));
            System.out.println("  - Fecha Registro: " + (ultimo.getRecordedAt() != null ? ultimo.getRecordedAt().toString() : "N/A"));
         } catch (Exception e) {
             System.out.println("Error: " + e.getMessage());
         }
     }
 }
