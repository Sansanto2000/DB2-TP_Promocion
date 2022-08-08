db = db.getSiblingDB("accidents");
db.accident.updateMany({}, [
  {
    $set: {
      location: { type: "Point", coordinates: ["$Start_Lng", "$Start_Lat"] },
    },
  },
]);
db.accident.createIndex({ location: "2dsphere" });
