print('init-mongo-2.js #######################################################');
db = db.getSiblingDB("DB2_promo");
db.accident.updateMany({}, [
    {
        $set: {
            location: { type: "Point", coordinates: ["$Start_Lng", "$Start_Lat"] },
        },
    },
]);
db.accident.createIndex({ location: "2dsphere" });
print('END #################################################################');