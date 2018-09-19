// tag::copyright[]
/*******************************************************************************
 * Copyright (c) 2018 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - Initial implementation
 *******************************************************************************/
// end::copyright[]
package io.openliberty.guides.jpaguide.resources;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.Disposes;

@RequestScoped
public class EntityManagerProducer{

    @PersistenceUnit(name = "jpa-unit")
    EntityManagerFactory emf;

    @Produces
    @RequestScoped
    public EntityManager newEntityManager(){
        return emf.createEntityManager();
    }

    public void deleteEntityManager(@Disposes EntityManager em){
        em.close();
    }

}