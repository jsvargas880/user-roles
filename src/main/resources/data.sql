INSERT INTO ROLES(role_name)
SELECT 'ADMIN'
    WHERE NOT EXISTS (
    SELECT 1
    FROM ROLES
    WHERE role_name = 'ADMIN'
);

INSERT INTO ROLES(role_name)
SELECT 'USER'
    WHERE NOT EXISTS (
    SELECT 1
    FROM ROLES
    WHERE role_name = 'USER'
);

INSERT INTO ROLES(role_name)
SELECT 'SELLER'
    WHERE NOT EXISTS (
    SELECT 1
    FROM ROLES
    WHERE role_name = 'SELLER'
);

INSERT INTO ROLES(role_name)
SELECT 'CUSTOMER'
    WHERE NOT EXISTS (
    SELECT 1
    FROM ROLES
    WHERE role_name = 'CUSTOMER'
);


INSERT INTO USERS(name, email)
VALUES ('Jose', 'vargasjo@gmail.com');
INSERT INTO USER_ROLE(role_id, user_id) VALUES (1, 1);
INSERT INTO USER_ROLE(role_id, user_id) VALUES (2, 1);