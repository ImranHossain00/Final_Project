package com.sir.tech.bd.domain;

import java.time.LocalDateTime;

public abstract class Domain {
    private Long id;
    private Long version = 0L;
    private LocalDateTime date_created
            = LocalDateTime.now();
    private LocalDateTime date_last_updated
            = LocalDateTime.now();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public LocalDateTime getDate_created() {
        return date_created;
    }

    public void setDate_created(LocalDateTime date_created) {
        this.date_created = date_created;
    }

    public LocalDateTime getDate_last_updated() {
        return date_last_updated;
    }

    public void setDate_last_updated(LocalDateTime date_last_updated) {
        this.date_last_updated = date_last_updated;
    }
}
