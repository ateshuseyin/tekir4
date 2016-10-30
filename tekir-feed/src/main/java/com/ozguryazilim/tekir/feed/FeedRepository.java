/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ozguryazilim.tekir.feed;

import com.ozguryazilim.tekir.entities.Feed;
import com.ozguryazilim.telve.data.RepositoryBase;
import java.util.List;
import javax.enterprise.context.Dependent;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.QueryParam;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.criteria.CriteriaSupport;

/**
 * Feed Repository Class
 * 
 * @author Hakan Uygun
 */
@Repository
@Dependent
public abstract class FeedRepository extends RepositoryBase<Feed, Feed> implements CriteriaSupport<Feed>{


    /**
     * Geriye ismi verilen feature ile ilgili olan feedleri döndürür.
     * 
     * @param feature
     * @return 
     */
    @Query( "select f from Feed f where f.basePointer.feature = :feature or f.relatedPointer.feature = :feature")
    public abstract List<Feed> findForFeature( @QueryParam("feature") String feature );
    
    @Query( "select f from Feed f where ( f.basePointer.feature = :feature and f.basePointer.primaryKey = :id ) or ( f.relatedPointer.feature = :feature and f.relatedPointer.primaryKey = :id )")
    public abstract List<Feed> findForFeature( @QueryParam("feature") String feature, @QueryParam("id") Long id );
}
