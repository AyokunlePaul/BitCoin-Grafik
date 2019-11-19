package com.ayokunlepaul.repository.mapper

interface RepositoryMapper <FROM, TO> {

    fun mapToRepository(from: FROM): TO

    fun mapFromRepository(to: TO): FROM

    fun mapToRepositoryList(fromList: List<FROM>): List<TO> = fromList.map { mapToRepository(it) }

    fun mapFromRepositoryList(toList: List<TO>): List<FROM> = toList.map { mapFromRepository(it) }

    fun safeString(value: String?) = value ?: "N/A"

    fun safeInt(value: Int?) = value ?: 0

    fun safeList(value: List<Any>?) = value ?: emptyList()
}