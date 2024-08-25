
async function main() {
    let res
    res = await postRestaurantTest("Rabbit Restaurant", 0.1, "Rabbit Island");
    console.log(await res.json());

    res = await postRestaurantTest("Turtle Restaurant", 1.0, "Turtle Island");
    console.log(await res.json());

    res = await postRestaurantTest("CPU Restaurant", 0.0, "Earth");
    console.log(await res.json());
}



/**
 * @param {String} name 
 * @param {Number} rating 
 * @param {String} location 
 * @returns {Promise<Response>}
 */
async function postRestaurantTest(name, rating, location) {
    return await fetch("http://localhost:8090/restaurant", {
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            name: name,
            rating: rating,
            location: location
        }
        )
    })
}

main();