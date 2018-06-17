package com.shiveenp.jpa

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NearEarthObjectRepository : JpaRepository<NearEarthObjectData, Long>