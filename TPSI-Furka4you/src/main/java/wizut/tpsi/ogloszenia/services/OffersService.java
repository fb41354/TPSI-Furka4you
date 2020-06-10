package wizut.tpsi.ogloszenia.services;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import wizut.tpsi.ogloszenia.jpa.BodyStyle;
import wizut.tpsi.ogloszenia.jpa.CarManufacturer;
import wizut.tpsi.ogloszenia.jpa.CarModel;
import wizut.tpsi.ogloszenia.jpa.FuelType;
import wizut.tpsi.ogloszenia.jpa.Offer;
import wizut.tpsi.ogloszenia.web.OfferFilter;

@Service
@Transactional
public class OffersService {

    @PersistenceContext
    private EntityManager em;

    public CarManufacturer getCarManufacturer(int id) {
        return em.find(CarManufacturer.class, id);
    }

    public CarModel getCarModel(int id) {
        return em.find(CarModel.class, id);
    }

    public List<CarManufacturer> getCarManufacturers() {
        String jpql = "select cm from CarManufacturer cm order by cm.name";
        TypedQuery<CarManufacturer> query = em.createQuery(jpql, CarManufacturer.class);
        List<CarManufacturer> result = query.getResultList();
        return result;
    }

    public List<BodyStyle> getBodyStyles() {
        String jpql = "select bs from BodyStyle bs order by bs.name";
        TypedQuery<BodyStyle> query = em.createQuery(jpql, BodyStyle.class);
        List<BodyStyle> result = query.getResultList();
        return result;
    }

    public List<FuelType> getFuelTypes() {
        String jpql = "select ft from FuelType ft order by ft.name";
        TypedQuery<FuelType> query = em.createQuery(jpql, FuelType.class);
        List<FuelType> result = query.getResultList();
        return result;
    }

    public List<CarModel> getCarModels() {
        String jpql = "select cm from CarModel cm order by cm.name";
        TypedQuery<CarModel> query = em.createQuery(jpql, CarModel.class);
        List<CarModel> result = query.getResultList();
        return result;
    }

    public List<Offer> getOffers() {
        String jpql = "select o from Offer o order by o.title";
        TypedQuery<Offer> query = em.createQuery(jpql, Offer.class);
        List<Offer> result = query.getResultList();
        return result;
    }

    public List<CarModel> getCarModels(int manufacturerId) {
        String jpql = "select cm from CarModel cm where cm.manufacturer.id = :id order by cm.name";

        TypedQuery<CarModel> query = em.createQuery(jpql, CarModel.class);
        query.setParameter("id", manufacturerId);

        return query.getResultList();
    }

    public List<Offer> getOffersByManufacturer(int manufacturerId) {
        String jpql = "select o from Offer o where o.model.manufacturer.id = :id order by o.title";

        TypedQuery<Offer> query = em.createQuery(jpql, Offer.class);
        query.setParameter("id", manufacturerId);

        return query.getResultList();
    }

    public List<Offer> getOffersByModel(int modelId) {
        String jpql = "select o from Offer o where o.model.id = :id order by o.title";

        TypedQuery<Offer> query = em.createQuery(jpql, Offer.class);
        query.setParameter("id", modelId);

        return query.getResultList();
    }

    public List<Offer> getOffers(OfferFilter filter) {

        String queryString = "select off from Offer off where 1=1 ";

        Integer manufacturerId = filter.getManufacturerId();
        Integer modelId = filter.getModelId();
        Integer minYear = filter.getMinYear();
        Integer maxYear = filter.getMaxYear();
        Integer fuelType = filter.getFuelType();

        if (manufacturerId != null) {
            queryString = queryString.concat("and off.model.manufacturer.id = :manufacturerId ");
        }
        if (modelId != null) {
            queryString = queryString.concat("and off.model.id = :modelId ");
        }
        if (minYear != null) {
            queryString = queryString.concat("and off.year >= :minYear ");
        }
        if (maxYear != null) {
            queryString = queryString.concat("and off.year <= :maxYear ");
        }
        if (fuelType != null) {
            queryString = queryString.concat("and off.fuelType.id = :fuelType ");
        }

        TypedQuery<Offer> query = em.createQuery(queryString, Offer.class);

        if (manufacturerId != null) {
            query.setParameter("manufacturerId", manufacturerId);
        }
        if (modelId != null) {
            query.setParameter("modelId", modelId);
        }
        if (minYear != null) {
            query.setParameter("minYear", minYear);
        }
        if (maxYear != null) {
            query.setParameter("maxYear", maxYear);
        }
        if (fuelType != null) {
            query.setParameter("fuelType", fuelType);
        }

        List<Offer> result = query.getResultList();
        return result;
    }

    public Offer getOffer(int id) {
        return em.find(Offer.class, id);
    }

    public Offer createOffer(Offer offer) {
        em.persist(offer);
        return offer;
    }

    public Offer deleteOffer(Integer id) {
        Offer offer = em.find(Offer.class, id);
        em.remove(offer);
        return offer;
    }
    
    public Offer saveOffer(Offer offer) {
    return em.merge(offer);
}
}
