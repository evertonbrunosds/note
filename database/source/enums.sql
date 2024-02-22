CREATE TYPE relationship_state AS ENUM (
    'ACCEPTED',
    'PENDING',
    'BLOCKED'
);

CREATE TYPE userprofile_state AS ENUM (
    'PUBLIC',
    'PRIVATE',
    'PROTECTED',
    'HIDDEN'
);
