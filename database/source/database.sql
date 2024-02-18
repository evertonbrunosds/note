CREATE TABLE kind (
    id uuid not null default uuid_generate_v4() PRIMARY KEY,
    userprofile_id uuid not null,
    name varchar(32) not null
);

CREATE TABLE change_password (
    id uuid not null default uuid_generate_v4() PRIMARY KEY,
    userprofile_id uuid not null UNIQUE,
    activation_key char(192) not null check(length(activation_key) = 192),
    created_at timestamp with time zone not null default current_timestamp
);

CREATE TABLE note (
    id uuid not null default uuid_generate_v4() PRIMARY KEY,
    kind_id uuid not null,
    title varchar(32) not null,
    content text not null,
    created_at timestamp with time zone not null default current_timestamp
);

CREATE TABLE change_email (
    id uuid not null default uuid_generate_v4() PRIMARY KEY,
    userprofile_id uuid not null UNIQUE,
    email varchar(256) not null,
    activation_key char(192) not null check(length(activation_key) = 192),
    created_at timestamp with time zone not null default current_timestamp
);

CREATE TABLE userprofile (
    id uuid not null default uuid_generate_v4() PRIMARY KEY,
    username varchar(64) not null,
    email varchar(256) not null,
    caption varchar(32) not null,
    description text,
    birthday date not null,
    password char(60) not null check(length(password) = 60),
    created_at timestamp with time zone not null default current_timestamp,
    UNIQUE (username, email)
);

CREATE TABLE relationship (
    follower_id uuid not null check (follower_id != followed_id),
    followed_id uuid not null check (followed_id != follower_id),
    state relationship_state not null default 'PENDING',
    created_at timestamp with time zone not null default current_timestamp,
    PRIMARY KEY (follower_id, followed_id)
);

CREATE TABLE verify_change_email (
    id uuid not null default uuid_generate_v4() PRIMARY KEY,
    change_email_id uuid not null UNIQUE,
    activation_key char(192) not null check(length(activation_key) = 192),
    created_at timestamp with time zone not null default current_timestamp
);

CREATE TABLE verify_email (
    id uuid not null default uuid_generate_v4() PRIMARY KEY,
    userprofile_id uuid not null UNIQUE,
    activation_key char(192) not null check(length(activation_key) = 192),
    created_at timestamp with time zone not null default current_timestamp
);
 
ALTER TABLE kind ADD CONSTRAINT kind_pk_userprofile_fk
    FOREIGN KEY (userprofile_id)
    REFERENCES userprofile (id);
 
ALTER TABLE change_password ADD CONSTRAINT change_password_pk_userprofile_fk
    FOREIGN KEY (userprofile_id)
    REFERENCES userprofile (id);
 
ALTER TABLE note ADD CONSTRAINT note_pk_kind_fk
    FOREIGN KEY (kind_id)
    REFERENCES kind (id);
 
ALTER TABLE change_email ADD CONSTRAINT change_email_pk_userprofile_fk
    FOREIGN KEY (userprofile_id)
    REFERENCES userprofile (id);
 
ALTER TABLE relationship ADD CONSTRAINT relationship_pk_userprofile_fk_fllower_id
    FOREIGN KEY (follower_id)
    REFERENCES userprofile (id);
 
ALTER TABLE relationship ADD CONSTRAINT relationship_pk_userprofile_fk_fllowed_id
    FOREIGN KEY (followed_id)
    REFERENCES userprofile (id);
 
ALTER TABLE verify_change_email ADD CONSTRAINT verify_change_email_pk_change_email_fk
    FOREIGN KEY (change_email_id)
    REFERENCES change_email (id);
 
ALTER TABLE verify_email ADD CONSTRAINT verify_enail_pk_user_profile_fk
    FOREIGN KEY (userprofile_id)
    REFERENCES userprofile (id);
