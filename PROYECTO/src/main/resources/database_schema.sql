-- ============================================
-- SCRIPT SQL DDL PARA SISTEMA HOSPITALARIO HOSSYS
-- ============================================
-- Este script crea todas las tablas necesarias para el sistema
-- Usa CREATE TABLE IF NOT EXISTS para no borrar datos existentes
-- ============================================

-- Tabla de usuarios (login y autenticación)
CREATE TABLE IF NOT EXISTS users (
    id VARCHAR(36) PRIMARY KEY,
    document VARCHAR(50),
    name VARCHAR(255),
    phone_number VARCHAR(50),
    birth_date DATE,
    address VARCHAR(500),
    gender VARCHAR(10),
    role VARCHAR(50),
    username VARCHAR(100) UNIQUE,
    email VARCHAR(255),
    password VARCHAR(255),
    INDEX idx_username (username),
    INDEX idx_document (document),
    INDEX idx_role (role)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Tabla de doctores
CREATE TABLE IF NOT EXISTS doctors (
    id VARCHAR(36) PRIMARY KEY,
    document VARCHAR(50) NOT NULL UNIQUE,
    name VARCHAR(255) NOT NULL,
    phone_number VARCHAR(50),
    address VARCHAR(500),
    gender VARCHAR(10),
    birth_date DATE,
    role VARCHAR(50),
    INDEX idx_document (document),
    INDEX idx_role (role)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Tabla de enfermeras
CREATE TABLE IF NOT EXISTS enfermeras (
    id VARCHAR(36) PRIMARY KEY,
    document VARCHAR(50) NOT NULL UNIQUE,
    name VARCHAR(255) NOT NULL,
    phone_number VARCHAR(50),
    address VARCHAR(500),
    gender VARCHAR(10),
    birth_date DATE,
    role VARCHAR(50),
    license_number VARCHAR(100),
    department VARCHAR(255),
    INDEX idx_document (document),
    INDEX idx_role (role)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Tabla de RRHH
CREATE TABLE IF NOT EXISTS rrhh (
    id VARCHAR(36) PRIMARY KEY,
    document VARCHAR(50) NOT NULL UNIQUE,
    name VARCHAR(255) NOT NULL,
    phone_number VARCHAR(50),
    address VARCHAR(500),
    gender VARCHAR(10),
    birth_date DATE,
    role VARCHAR(50),
    employee_id VARCHAR(100),
    department VARCHAR(255),
    INDEX idx_document (document),
    INDEX idx_role (role)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Tabla de pacientes
CREATE TABLE IF NOT EXISTS patients (
    id VARCHAR(36) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    document VARCHAR(50) NOT NULL UNIQUE,
    birth_date DATE,
    address VARCHAR(500),
    phone_number VARCHAR(50),
    gender VARCHAR(10),
    role VARCHAR(50),
    -- Campos embebidos de EmergencyContact
    emergency_contact_name VARCHAR(255),
    emergency_contact_relationship VARCHAR(100),
    emergency_contact_phone VARCHAR(50),
    -- Campos embebidos de HealthInsurance
    insurance_id VARCHAR(100),
    insurance_provider_name VARCHAR(255),
    insurance_policy_number VARCHAR(100),
    insurance_coverage_details TEXT,
    INDEX idx_document (document),
    INDEX idx_role (role)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Tabla de pólizas (relacionada con pacientes)
CREATE TABLE IF NOT EXISTS polizas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    numero_poliza VARCHAR(100) NOT NULL UNIQUE,
    asegurado VARCHAR(255),
    vigencia_inicio DATE,
    vigencia_fin DATE,
    estado VARCHAR(50),
    id_paciente VARCHAR(36) NOT NULL,
    FOREIGN KEY (id_paciente) REFERENCES patients(id) ON DELETE CASCADE,
    INDEX idx_numero_poliza (numero_poliza),
    INDEX idx_paciente (id_paciente),
    INDEX idx_estado (estado)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Tabla de medicamentos
CREATE TABLE IF NOT EXISTS medicamentos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    cantidad_disponible INT DEFAULT 0,
    dosis VARCHAR(255),
    fecha_vencimiento DATE,
    precio_unitario DECIMAL(10,2),
    id_doctor_prescriptor VARCHAR(36),
    FOREIGN KEY (id_doctor_prescriptor) REFERENCES doctors(id) ON DELETE SET NULL,
    INDEX idx_nombre (nombre),
    INDEX idx_doctor (id_doctor_prescriptor)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Tabla de órdenes médicas
CREATE TABLE IF NOT EXISTS ordenes_medicas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_paciente VARCHAR(36) NOT NULL,
    id_doctor VARCHAR(36) NOT NULL,
    fecha DATETIME DEFAULT CURRENT_TIMESTAMP,
    estado VARCHAR(50),
    descripcion TEXT,
    diagnostico VARCHAR(500),
    observaciones TEXT,
    FOREIGN KEY (id_paciente) REFERENCES patients(id) ON DELETE CASCADE,
    FOREIGN KEY (id_doctor) REFERENCES doctors(id) ON DELETE CASCADE,
    INDEX idx_paciente (id_paciente),
    INDEX idx_doctor (id_doctor),
    INDEX idx_fecha (fecha)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Tabla puente: orden_medicamento (relación Many-to-Many)
CREATE TABLE IF NOT EXISTS orden_medicamento (
    orden_id BIGINT NOT NULL,
    medicamento_id BIGINT NOT NULL,
    PRIMARY KEY (orden_id, medicamento_id),
    FOREIGN KEY (orden_id) REFERENCES ordenes_medicas(id) ON DELETE CASCADE,
    FOREIGN KEY (medicamento_id) REFERENCES medicamentos(id) ON DELETE CASCADE,
    INDEX idx_orden (orden_id),
    INDEX idx_medicamento (medicamento_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Tabla de invoices (facturas)
CREATE TABLE IF NOT EXISTS invoices (
    id VARCHAR(36) PRIMARY KEY,
    id_paciente VARCHAR(36) NOT NULL,
    id_orden_medica BIGINT,
    fecha DATE NOT NULL,
    total DECIMAL(10,2) NOT NULL DEFAULT 0.00,
    status VARCHAR(50) DEFAULT 'PENDIENTE',
    policy_id VARCHAR(100),
    insurance_company_name VARCHAR(255),
    FOREIGN KEY (id_paciente) REFERENCES patients(id) ON DELETE CASCADE,
    FOREIGN KEY (id_orden_medica) REFERENCES ordenes_medicas(id) ON DELETE SET NULL,
    INDEX idx_paciente (id_paciente),
    INDEX idx_orden (id_orden_medica),
    INDEX idx_fecha (fecha),
    INDEX idx_status (status)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Tabla puente: invoice_medicamento (relación Many-to-Many)
CREATE TABLE IF NOT EXISTS invoice_medicamento (
    invoice_id VARCHAR(36) NOT NULL,
    medicamento_id BIGINT NOT NULL,
    PRIMARY KEY (invoice_id, medicamento_id),
    FOREIGN KEY (invoice_id) REFERENCES invoices(id) ON DELETE CASCADE,
    FOREIGN KEY (medicamento_id) REFERENCES medicamentos(id) ON DELETE CASCADE,
    INDEX idx_invoice (invoice_id),
    INDEX idx_medicamento (medicamento_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ============================================
-- COMENTARIOS SOBRE LA ESTRUCTURA
-- ============================================
-- 1. Las tablas users, doctors, enfermeras, rrhh, patients están separadas
--    pero pueden ligarse por documento o por lógica de aplicación
-- 2. Las pólizas están relacionadas con pacientes mediante FK
-- 3. Las órdenes médicas relacionan pacientes y doctores
-- 4. Los medicamentos pueden tener un doctor prescriptor
-- 5. Los invoices se generan automáticamente cuando hay medicamentos en órdenes
-- 6. Se usan tablas puente para relaciones Many-to-Many
-- ============================================

